package TJCore.api;

import TJCore.TJValues;
import TJCore.api.material.materials.info.TJMaterialIconTypes;
import com.brandon3055.draconicevolution.DEFeatures;
import gregtech.api.GTValues;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;

import static TJCore.common.recipes.recipemaps.TJRecipeMaps.NANOSCALE_GROWTH_RECIPES;
import static TJCore.api.material.TJMaterials.doNotGenerate;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;
import static gregtech.api.unification.ore.OrePrefix.*;

public class TJOreDictionaryLoader {

    public static final MaterialFlag GENERATE_NANOWIRE = new MaterialFlag.Builder("generate_nanowire")
            .requireProps(PropertyKey.FLUID)
            .build();

    public static final MaterialFlag GENERATE_NANOFOIL = new MaterialFlag.Builder("generate_nanofoil")
            .requireProps(PropertyKey.FLUID)
            .build();
    public static final OrePrefix nanowire = new OrePrefix("nanowire", GTValues.M / 144, null, TJMaterialIconTypes.nanoWireIcon, ENABLE_UNIFICATION, material -> ((material.isElement() && material.isSolid() && material.hasFluid() && (!Arrays.toString(doNotGenerate).contains(material.toString()))) || material.hasFlag(GENERATE_NANOWIRE)));
    public static final OrePrefix nanofoil = new OrePrefix("nanofoil", GTValues.M / 144, null, TJMaterialIconTypes.nanoFoilIcon, ENABLE_UNIFICATION, material -> ((material.isElement() && material.isSolid() && material.hasFluid() && (!Arrays.toString(doNotGenerate).contains(material.toString()))) || material.hasFlag(GENERATE_NANOFOIL)));

    public static void init() {
        registerOrePrefixes();
        if (Loader.isModLoaded("draconicevolution")) {
            initDE();
        }
    }

    @Optional.Method(modid = "draconicevolution")
    private static void initDE() {
        for (int i = 0; i < 12; i++) {
            OreDictionary.registerOre("itemUpgradeKey", new ItemStack(DEFeatures.toolUpgrade, 1, i));
        }
    }

    public static void registerOrePrefixes() {
        createMaterialItem(nanowire);
        createMaterialItem(nanofoil);

    }

    public static void registerRecipes() {
        nanowire.addProcessingHandler(PropertyKey.INGOT, TJOreDictionaryLoader::processNanoWire);
        nanofoil.addProcessingHandler(PropertyKey.INGOT, TJOreDictionaryLoader::processNanoFoil);
    }
    public static void processNanoFoil(OrePrefix nanoFoilPrefix, Material material, IngotProperty property) {
        if (material.hasProperty(PropertyKey.FLUID)) {
            NANOSCALE_GROWTH_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .duration(40)
                    .EUt(VA[ZPM])
                    .fluidInputs(material.getFluid(1))
                    .output(nanoFoilPrefix, material)
                    .buildAndRegister();
        }
    }

    public static void processNanoWire(OrePrefix nanoFoilPrefix, Material material, IngotProperty property) {
        if (material.hasProperty(PropertyKey.FLUID)) {
            NANOSCALE_GROWTH_RECIPES.recipeBuilder()
                    .circuitMeta(0)
                    .duration(40)
                    .EUt(VA[ZPM])
                    .fluidInputs(material.getFluid(1))
                    .output(nanoFoilPrefix, material)
                    .buildAndRegister();
        }
    }

    public static void createMaterialItem(OrePrefix orePrefix) {
        MetaPrefixItem item = new MetaPrefixItem(orePrefix);
        item.setRegistryName(TJValues.MODID, orePrefix.name());
    }
}
