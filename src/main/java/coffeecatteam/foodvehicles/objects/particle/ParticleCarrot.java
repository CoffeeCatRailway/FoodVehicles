package coffeecatteam.foodvehicles.objects.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleCarrot extends Particle {

    public ParticleCarrot(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
        super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
        this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(Items.CARROT));
        ParticleManager manager = new ParticleManager(this.world, Minecraft.getMinecraft().renderEngine);
        manager.registerParticle(-1, new ParticleCarrot.Factory());
    }


    @SideOnly(Side.CLIENT)
    public static class Factory implements IParticleFactory {
        public Particle createParticle(int particleID, World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... p_178902_15_) {
            return new ParticleCarrot(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
        }
    }
}
