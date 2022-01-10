package TJCore.common.metatileentities;

import TJCore.TJValues;
import TJCore.common.metatileentities.multi.SteamAssembler;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.util.ResourceLocation;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import static gregtech.common.metatileentities.MetaTileEntities.*;

import java.util.function.Function;

public class TJMetaTileEntities {

    // MACHINE ID 12000-12599

    public static  SimpleMachineMetaTileEntity[] COMPONENT_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];
    public static  SteamAssembler STEAM_ASSEMBLER = new SteamAssembler(tjcoreID("steam_assembler"));

    public static void init() {
        registerSimpleMetaTileEntity(COMPONENT_ASSEMBLER, 12001, "component_assembler", TJRecipeMaps.COMPONENT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, false);
       registerMetaTileEntity(12010, STEAM_ASSEMBLER);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing, Function<Integer, Integer> tankScalingFunction) {
        MetaTileEntities.registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, s -> tjcoreID(s), tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing) {
        registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GTUtility.defaultTankSizeFunction);
    }

    private static ResourceLocation tjcoreID(String name) {
        return new ResourceLocation(TJValues.MODID, name);

    }

}
