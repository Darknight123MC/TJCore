package TJCore.common.recipes.recipemaps;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.sound.GTSounds;

public class TJRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPE_MAP = new RecipeMap<>("component_assembler", 3, 6, 1, 1, 1,1, 0,0, new SimpleRecipeBuilder(), false).setSound(GTSounds.TRICORDER_TOOL);

    public static void initRecipeMaps() {
        //COMPONENT_ASSEMBLER_RECIPE_MAP =
    }

}
