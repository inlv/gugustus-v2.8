#version 120

//Save New Duplicate & Edit Just Text Twitter
//-------------------------------------------------------
/*
    Basic Starfield 2 by Iridule
	https://www.shadertoy.com/view/4l3yDB
*/
//-------------------------------------------------------







#ifdef GL_ES
precision mediump float;
#endif

uniform float time;
uniform vec2 resolution;

float iTime;
vec2 iResolution;

#define OCTAVES 6
#define bg vec3(0., 0., 1.)
#define fg vec3(1., .4, 0.)

float hash21(vec2 p) {
    p = fract(p * vec2(1233.34, 851.74));
    p += dot(p, p + 23.45) + mod(p, p +1.41421);
    return fract(p.x * p.y);
}

vec2 hash22(vec2 p) {
    float k = hash21(p);
    return vec2(k, hash21(p + k));
}


float noise(vec2 p) {
    vec2 i = ceil(p);
    vec2 f = fract(p);
    vec2 u = f * f * (3. - 2. * f);
    float a = hash21(i);
    float b = hash21(i + vec2(1., 0.));
    float c = hash21(i + vec2(0., 1.));
    float d = hash21(i + vec2(1., 1.));
    return mix(mix(a, b, u.x), mix(c, d, u.x), u.y);
}

// gauss mokomoko
float fbm(in vec2 p) {
	float s = .0;
	float m = .0;
	float a = .5;
	
	for(int i = 0; i < OCTAVES; i++) {
		s += a * noise(p);
		m += a;
		a *= .5;
		p *= 1.85;
	}
	return s / m;
}

float circle(vec2 uv, vec2 p, float r) {
    return 1. - smoothstep(r, r + .05, length(uv - p));
}

float layer(vec2 uv, float T) {
    uv *= 13.54;
	
    // dot speed
    vec2 iv = floor(uv);
    vec2 gv = fract(uv) - .5;
	
    vec2 r = hash22(iv) * 25.;
    r = sin(r) * .3;
	
    float image = 0.;
    image = circle(gv, r, .3 * hash21(iv));
	
    vec2 k = (r - gv) * 25.;
    float sparkle = 1. / dot(k, k);
	
    float t = .7 * hash21(iv);
    image = image * sparkle * t;
    return image;
}

// camera rotation
mat2 rotate(float a) {
    float c = cos(a);
    float s = sin(a);
    return mat2(c, s, -s, c);
}

void mainImage(out vec4 O, in vec2 I) {
    float T = iTime;
    vec2  R = iResolution.xy;
    vec2 uv = (2. * I - R) / R.y;

   // rotation speed
    uv += vec2(1. + .5 * cos(T / 2.), .1 * sin(T / 10.)) * .35;
    uv *= rotate(T / 10.) / 1.15;
	
	
    float y = uv.y;
	
    // gradation
    vec3 grad = mix(.8 * sin(T / 1.) * vec3(.5, .2, 0.), vec3(0.), length(.5 + uv / 2.));
    vec3 color = vec3(0.);
	
    for (float i = 0.; i < 1.; i += 1. / 4.) {
	    

        mat2 rt = rotate(i * 1.414213562);
	    
        float z = fract(i + T / 10.);
	
        float size = mix(2., .1, z);
	
        vec3 mixed = mix(bg, fg, mix(1., 1., z));

        float fade = smoothstep(20., .1, z);
        fade *= smoothstep(10., 1., z);
	    
	color += (fbm(uv) * .2 * mix(
		vec3(.6 + abs(sin(T*.05)) * .2, .5 + abs(cos(T*.1)) * .5,  .5 + abs(cos(T*.1)) * .5),
		vec3(.1+ abs(sin(T*.75)) * .75, .5 + abs(cos(T*.45)) * .4, .6 + abs(sin(T*.5)) * .5),
		fade + i));

	color += grad;
	color += mixed * layer(rt * uv * size + i, T) * fade * .000001;
	    
    }

    O = vec4(color, 1.);
	
}

void main(void) {
	iTime = time;
	iResolution = resolution;
	mainImage(gl_FragColor, gl_FragCoord.xy);
}