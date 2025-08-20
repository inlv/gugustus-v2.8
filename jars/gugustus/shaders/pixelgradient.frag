/*
 * Original shader from: https://www.shadertoy.com/view/wtdfDn
 */

#ifdef GL_ES
precision highp float;
#endif

// glslsandbox uniforms
uniform float time;
uniform vec2 resolution;

// shadertoy emulation
#define iTime time
#define iResolution resolution

// --------[ Original ShaderToy begins here ]---------- //
#define NOISE_CUTOFF 0.66
#define SPEED 10.0

float rand(vec2 n) {
    return fract(sin(dot(n, vec2(12.9898, 4.1414))) * 43758.5453);
}

float noise(vec2 p){
    vec2 ip = floor(p);
    vec2 u = fract(p);
    u = u*u*(3.0-2.0*u);

    float res = mix(
    mix(rand(ip),rand(ip+vec2(1.0,0.0)),u.x),
    mix(rand(ip+vec2(0.0,1.0)),rand(ip+vec2(1.0,1.0)),u.x),u.y);
    return res*res;
}

float samplePoint(vec2 p) {
    float n = noise(p);
    n *= n * n * n;
    n = step(NOISE_CUTOFF, n);

    return n;
}

float layer(vec2 fragCoord, float scale) {
    float n = 0.0;

    vec2 squared = floor((fragCoord + vec2(0, SPEED*iTime))/scale);
    n += samplePoint(squared);
    n += 0.5*samplePoint(squared - vec2(0., 1.));
    n += 0.25*samplePoint(squared - vec2(0., 2.));
    n += 0.125*samplePoint(squared - vec2(0., 3.));

    return n;
}

mat2 rotate2d(float _angle){
    return mat2(cos(_angle),-sin(_angle),
    sin(_angle),cos(_angle));
}

vec3 decodeSRGB(vec3 screenRGB)
{
    vec3 a = screenRGB / 12.92;
    vec3 b = pow((screenRGB + 0.055) / 1.055, vec3(2.4));
    vec3 c = step(vec3(0.04045), screenRGB);
    return mix(a, b, c);
}

void mainImage( out vec4 fragColor, in vec2 fragCoord )
{
    vec3 c = vec3(0.);
    c += 1.4*layer(rotate2d(0.2)*fragCoord, 2.0) * vec3(32./255., 57./255., 99./255.);
    c += 1.73*layer(rotate2d(-0.4)*fragCoord, 4.0) * vec3(34./255., 67./255., 75./255.);
    c += 1.87*layer(rotate2d(1.5)*fragCoord, 6.0) * vec3(37./255., 72./255., 72./255.);
    c += 2.*layer(rotate2d(-0.8)*fragCoord, 10.0) * vec3(41./255., 74./255., 61./255.);

    fragColor = vec4(decodeSRGB(c),1.0);
}
// --------[ Original ShaderToy ends here ]---------- //

void main(void)
{
    mainImage(gl_FragColor, gl_FragCoord.xy);
}