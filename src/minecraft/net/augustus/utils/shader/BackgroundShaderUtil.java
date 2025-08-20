package net.augustus.utils.shader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;

import net.augustus.Augustus;

public class BackgroundShaderUtil {
    private final ArrayList<ShaderUtil> shaders = new ArrayList<>();
    private final ArrayList<String> shaderNames = new ArrayList<>();
    private ShaderUtil currentShader;

    public BackgroundShaderUtil() {
        this.saveResource("shaders/abraxas.frag", "gugustus", false);
        this.saveResource("shaders/galaxy.frag", "gugustus", false);
        this.saveResource("shaders/galaxy2.frag", "gugustus", false);
        this.saveResource("shaders/purplewater.frag", "gugustus", false);
        this.saveResource("shaders/liquidbounce.frag", "gugustus", false);
        this.saveResource("shaders/redwaterlike.frag", "gugustus", false);
        this.saveResource("shaders/bluemetal.frag", "gugustus", false);
        this.saveResource("shaders/metal.frag", "gugustus", false);
        this.saveResource("shaders/snowstar.frag", "gugustus", false);
        this.saveResource("shaders/spider.frag", "gugustus", false);
        this.saveResource("shaders/trinity.frag", "gugustus", false);
        this.saveResource("shaders/bluefog.frag", "gugustus", false);
        this.saveResource("shaders/cloudtunnel.frag", "gugustus", false);
        this.saveResource("shaders/cute.frag", "gugustus", false);
        this.saveResource("shaders/idk.frag", "gugustus", false);
        this.saveResource("shaders/nature.frag", "gugustus", false);
        this.saveResource("shaders/race.frag", "gugustus", false);
        this.saveResource("shaders/mountains.frag", "gugustus", false);
        this.saveResource("shaders/purplecircle.frag", "gugustus", false);
        this.saveResource("shaders/RGB.frag", "gugustus", false);
        this.saveResource("shaders/sun.frag", "gugustus", false);
        this.saveResource("shaders/water.frag", "gugustus", false);
        // this.saveResource("shaders/RGBLines.frag", "gugustus", false);
        this.saveResource("shaders/wave.frag", "gugustus", false);
        this.saveResource("shaders/stadium.frag", "gugustus", false);
        this.saveResource("shaders/rainbowtunnel.frag", "gugustus", false);
        this.saveResource("shaders/rainbowwaves.frag", "gugustus", false);
        this.saveResource("shaders/reflection.frag", "gugustus", false);
        this.saveResource("shaders/rainbowdot.frag", "gugustus", false);
        this.saveResource("shaders/gamecube.frag", "gugustus", false);
        this.saveResource("shaders/car.frag", "gugustus", false);
        this.saveResource("shaders/Augustus1.frag", "gugustus", false);
        this.saveResource("shaders/Augustus2.frag", "gugustus", false);
        this.saveResource("shaders/auroras.frag", "gugustus", false);
        this.saveResource("shaders/bash.frag", "gugustus", false);
        this.saveResource("shaders/bash117.frag", "gugustus", false);
        this.saveResource("shaders/BasicStarfield2.frag", "gugustus", false);
        this.saveResource("shaders/blackhole.frag", "gugustus", false);
        this.saveResource("shaders/bloodmaxiter.frag", "gugustus", false);
        this.saveResource("shaders/BlueArt.frag", "gugustus", false);
        this.saveResource("shaders/bluefade.frag", "gugustus", false);
        this.saveResource("shaders/bluefade2.frag", "gugustus", false);
        this.saveResource("shaders/bubbles.frag", "gugustus", false);
        this.saveResource("shaders/burningsun.frag", "gugustus", false);
        this.saveResource("shaders/circle.frag", "gugustus", false);
        this.saveResource("shaders/Clean.frag", "gugustus", false);
        this.saveResource("shaders/clean2.frag", "gugustus", false);
        this.saveResource("shaders/core.frag", "gugustus", false);
        this.saveResource("shaders/core2.frag", "gugustus", false);
        this.saveResource("shaders/core3.frag", "gugustus", false);
        this.saveResource("shaders/core4.frag", "gugustus", false);
        this.saveResource("shaders/cryptonic_1_12.frag", "gugustus", false);
        this.saveResource("shaders/cube.frag", "gugustus", false);
        this.saveResource("shaders/cube2.frag", "gugustus", false);
        this.saveResource("shaders/Cubictrip.frag", "gugustus", false);
        this.saveResource("shaders/deadtome.frag", "gugustus", false);
        this.saveResource("shaders/debug.frag", "gugustus", false);
        this.saveResource("shaders/Deutschland.frag", "gugustus", false);
        this.saveResource("shaders/donut.frag", "gugustus", false);
        this.saveResource("shaders/dvdlogo.frag", "gugustus", false);
        this.saveResource("shaders/Dynamic.frag", "gugustus", false);
        this.saveResource("shaders/dynamic2.frag", "gugustus", false);
        this.saveResource("shaders/dynamic3.frag", "gugustus", false);
        this.saveResource("shaders/dynamic4.frag", "gugustus", false);
        this.saveResource("shaders/dynamic5.frag", "gugustus", false);
        this.saveResource("shaders/eject.frag", "gugustus", false);
        this.saveResource("shaders/ejectlila.frag", "gugustus", false);
        this.saveResource("shaders/fade.frag", "gugustus", false);
        this.saveResource("shaders/FavCurrent.frag", "gugustus", false);
        this.saveResource("shaders/fireworks.frag", "gugustus", false);
        this.saveResource("shaders/fixed_rednight.frag", "gugustus", false);
        this.saveResource("shaders/foggy.frag", "gugustus", false);
        this.saveResource("shaders/foggy2.frag", "gugustus", false);
        this.saveResource("shaders/fractal.frag", "gugustus", false);
        this.saveResource("shaders/full_polarlights.frag", "gugustus", false);
        this.saveResource("shaders/galaxystorm.frag", "gugustus", false);
        this.saveResource("shaders/geometry.frag", "gugustus", false);
        this.saveResource("shaders/ghosttravel.frag", "gugustus", false);
        this.saveResource("shaders/heart.frag", "gugustus", false);
        this.saveResource("shaders/idk1.frag", "gugustus", false);
        this.saveResource("shaders/labyrinth.frag", "gugustus", false);
        this.saveResource("shaders/lbday.frag", "gugustus", false);
        this.saveResource("shaders/lennidark.frag", "gugustus", false);
        this.saveResource("shaders/LenniZwei.frag", "gugustus", false);
        this.saveResource("shaders/LilaFrag.frag", "gugustus", false);
        this.saveResource("shaders/mandelbrot.frag", "gugustus", false);
        this.saveResource("shaders/master.frag", "gugustus", false);
        this.saveResource("shaders/matrix.frag", "gugustus", false);
        this.saveResource("shaders/maxiter.frag", "gugustus", false);
        this.saveResource("shaders/minecraft.frag", "gugustus", false);
        this.saveResource("shaders/neonsunrise.frag", "gugustus", false);
        this.saveResource("shaders/NShader1.frag", "gugustus", false);
        this.saveResource("shaders/NShader2.frag", "gugustus", false);
        this.saveResource("shaders/panorama.frag", "gugustus", false);
        this.saveResource("shaders/pixelgradient.frag", "gugustus", false);
        this.saveResource("shaders/polarlights.frag", "gugustus", false);
        this.saveResource("shaders/prestige.frag", "gugustus", false);
        this.saveResource("shaders/pulse.frag", "gugustus", false);
        this.saveResource("shaders/purple.frag", "gugustus", false);
        this.saveResource("shaders/purplefade.frag", "gugustus", false);
        this.saveResource("shaders/randomboxes.frag", "gugustus", false);
        this.saveResource("shaders/RandomGalaxy2.frag", "gugustus", false);
        this.saveResource("shaders/RandomGalaxy3.frag", "gugustus", false);
        this.saveResource("shaders/random_galaxy.frag", "gugustus", false);
        this.saveResource("shaders/rednight.frag", "gugustus", false);
        this.saveResource("shaders/rednightnew.frag", "gugustus", false);
        this.saveResource("shaders/RedOrangeDiashow.frag", "gugustus", false);
        this.saveResource("shaders/retrostarnight.frag", "gugustus", false);
        this.saveResource("shaders/retrosuntravel.frag", "gugustus", false);
        this.saveResource("shaders/retrowave.frag", "gugustus", false);
        this.saveResource("shaders/rickandmortylike.frag", "gugustus", false);
        this.saveResource("shaders/ricky.frag", "gugustus", false);
        this.saveResource("shaders/rings.frag", "gugustus", false);
        this.saveResource("shaders/rise1.frag", "gugustus", false);
        this.saveResource("shaders/rise2.frag", "gugustus", false);
        this.saveResource("shaders/rise3.frag", "gugustus", false);
        this.saveResource("shaders/river.frag", "gugustus", false);
        this.saveResource("shaders/rkblue.frag", "gugustus", false);
        this.saveResource("shaders/rkfadeside.frag", "gugustus", false);
        this.saveResource("shaders/rknight.frag", "gugustus", false);
        this.saveResource("shaders/sandstorm.frag", "gugustus", false);
        this.saveResource("shaders/sexy.frag", "gugustus", false);
        this.saveResource("shaders/singularity.frag", "gugustus", false);
        this.saveResource("shaders/snowflakes.frag", "gugustus", false);
        this.saveResource("shaders/snowtravel.frag", "gugustus", false);
        this.saveResource("shaders/space.frag", "gugustus", false);
        this.saveResource("shaders/space2.frag", "gugustus", false);
        this.saveResource("shaders/space3.frag", "gugustus", false);
        this.saveResource("shaders/squeezysound.frag", "gugustus", false);
        this.saveResource("shaders/star.frag", "gugustus", false);
        this.saveResource("shaders/starfog.frag", "gugustus", false);
        this.saveResource("shaders/startrip.frag", "gugustus", false);
        this.saveResource("shaders/TheEvolution.frag", "gugustus", false);
        this.saveResource("shaders/theshy.frag", "gugustus", false);
        this.saveResource("shaders/town.frag", "gugustus", false);
        this.saveResource("shaders/tunnel.frag", "gugustus", false);
        this.saveResource("shaders/ukraine.frag", "gugustus", false);
        this.saveResource("shaders/unicode.frag", "gugustus", false);

        File folder = new File("gugustus/shaders");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.getName().contains(".")) {
                String[] s = file.getName().split("\\.");
                if (s.length > 1 && s[1].equals("frag")) {
                    ShaderUtil shaderUtil = new ShaderUtil();
                    char[] arr = s[0].toCharArray();
                    arr[0] = Character.toUpperCase(arr[0]);
                    shaderUtil.createBackgroundShader(file.getAbsolutePath(), new String(arr));
                    this.shaders.add(shaderUtil);
                    this.shaderNames.add(shaderUtil.getName());
                }
            }
        }
        String shaderName = Augustus.getInstance().getConverter().readBackground();
        for (ShaderUtil shader : this.shaders) {
            if (shader.getName().equalsIgnoreCase(shaderName)) {
                this.currentShader = shader;
                return;
            }
        }
        this.currentShader = this.shaders.get(0);
    }

    public void setCurrentShader(String name) {
        for (ShaderUtil shaderUtil : this.shaders) {
            if (shaderUtil.getName().equalsIgnoreCase(name)) {
                this.currentShader = shaderUtil;
                Augustus.getInstance().getConverter().saveBackground(shaderUtil);
                return;
            }
        }
    }

    private void saveResource(String resourcePath, String dataFolder, boolean replace) {
        if (resourcePath != null && !resourcePath.equals("")) {
            resourcePath = resourcePath.replace('\\', '/');
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in client");
            } else {
                File outFile = new File(dataFolder, resourcePath);
                int lastIndex = resourcePath.lastIndexOf(47);
                File outDir = new File(dataFolder, resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));
                if (!outDir.exists()) {
                    outDir.mkdirs();
                }
                try {
                    if (!outFile.exists() || replace) {
                        OutputStream out = new FileOutputStream(outFile);
                        byte[] buf = new byte[1024];
                        int len;
                        while ((len = in.read(buf)) > 0) {
                            out.write(buf, 0, len);
                        }
                        out.close();
                        in.close();
                    }
                } catch (IOException var11) {
                    System.err.println(Level.SEVERE + "Could not save " + outFile.getName() + " to " + outFile);
                }
            }
        } else {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }
    }

    public ShaderUtil getCurrentShader() {
        return this.currentShader;
    }

    public ArrayList<ShaderUtil> getShaders() {
        return this.shaders;
    }

    public ArrayList<String> getShaderNames() {
        return this.shaderNames;
    }
}