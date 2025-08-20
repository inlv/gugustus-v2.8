package net.minecraft.client.resources;

import com.google.common.base.Charsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import net.augustus.utils.Logger;

public abstract class AbstractResourcePack implements IResourcePack {
   private static final Logger resourceLog = new Logger();
   public final File resourcePackFile;
   private static final String __OBFID = "CL_00001072";

   public AbstractResourcePack(File resourcePackFileIn) {
      this.resourcePackFile = resourcePackFileIn;
   }

   private static String locationToName(ResourceLocation location) {
      return String.format("%s/%s/%s", "assets", location.getResourceDomain(), location.getResourcePath());
   }

   protected static String getRelativeName(File p_110595_0_, File p_110595_1_) {
      return p_110595_0_.toURI().relativize(p_110595_1_.toURI()).getPath();
   }

   @Override
   public InputStream getInputStream(ResourceLocation location) throws IOException {
      return this.getInputStreamByName(locationToName(location));
   }

   @Override
   public boolean resourceExists(ResourceLocation location) {
      return this.hasResourceName(locationToName(location));
   }

   protected abstract InputStream getInputStreamByName(String var1) throws IOException;

   protected abstract boolean hasResourceName(String var1);

   protected void logNameNotLowercase(String p_110594_1_) {
      resourceLog.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", p_110594_1_, this.resourcePackFile);
   }

   @Override
   public IMetadataSection getPackMetadata(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException {
      return readMetadata(p_135058_1_, this.getInputStreamByName("pack.mcmeta"), p_135058_2_);
   }

   static IMetadataSection readMetadata(IMetadataSerializer p_110596_0_, InputStream p_110596_1_, String p_110596_2_) {
      JsonObject jsonobject = null;
      BufferedReader bufferedreader = null;

      try {
         bufferedreader = new BufferedReader(new InputStreamReader(p_110596_1_, Charsets.UTF_8));
         jsonobject = new JsonParser().parse(bufferedreader).getAsJsonObject();
      } catch (RuntimeException var9) {
         throw new JsonParseException(var9);
      } finally {
         IOUtils.closeQuietly((Reader)bufferedreader);
      }

      return p_110596_0_.parseMetadataSection(p_110596_2_, jsonobject);
   }

   @Override
   public BufferedImage getPackImage() throws IOException {
      return TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
   }

   @Override
   public String getPackName() {
      return this.resourcePackFile.getName();
   }
}
