package gregicality.science.client.render;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import tjcore.TJValues;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

@Mod.EventBusSubscriber(modid = TJValues.MODID, value = Side.CLIENT)
public class GCYSTextures {

    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible", FRONT);
    public static OrientedOverlayRenderer ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblock/roaster", FRONT);
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator", FRONT);
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblock/cvd_unit", FRONT);
    public static OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/burner_reactor", FRONT);
    public static OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/cryogenic_reactor", FRONT);
    public static OrientedOverlayRenderer FRACKER_OVERLAY = new OrientedOverlayRenderer("multiblock/fracker", FRONT);
    public static OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/sonicator", FRONT);
    public static OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblock/catalytic_reformer", FRONT);
    public static OrientedOverlayRenderer INDUSTRIAL_DRILL_OVERLAY = new OrientedOverlayRenderer("multiblock/industrial_drill", FRONT);
    public static OrientedOverlayRenderer SUBSONIC_AXIAL_COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("multiblock/subsonic_axial_compressor", FRONT);
    public static OrientedOverlayRenderer SUPERSONIC_AXIAL_COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("multiblock/supersonic_axial_compressor", FRONT);
    public static OrientedOverlayRenderer LOW_POWER_TURBOMOLECULAR_PUMP = new OrientedOverlayRenderer("multiblock/low_power_turbomolecular_pump", TOP);
    public static OrientedOverlayRenderer HIGH_POWER_TURBOMOLECULAR_PUMP = new OrientedOverlayRenderer("multiblock/high_power_turbomolecular_pump", TOP);

    public static TextureAtlasSprite PRESSURE_PIPE_SIDE;
    public static TextureAtlasSprite PRESSURE_PIPE_OPEN;
}
