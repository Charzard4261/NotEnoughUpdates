package io.github.moulberry.notenoughupdates.overlays;

import io.github.moulberry.notenoughupdates.NotEnoughUpdates;
import io.github.moulberry.notenoughupdates.core.config.Position;
import io.github.moulberry.notenoughupdates.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

// Contributed by Charzard4261
public class CityProjectPinOverlay extends TextOverlay {
    public Project pin;
    Project                    dummyProject;
    HashMap<String, ItemStack> dummyRenderers;
    ItemStack                  indent;


    public CityProjectPinOverlay(Position position, Supplier<List<String>> dummyStrings, Supplier<TextOverlayStyle> styleSupplier)
    {
        super(position, dummyStrings, styleSupplier);
        pin = getDummyProject();
        overlayStrings = new ArrayList<>();
    }

    public HashMap<String, ItemStack> getDummyRenderers()
    {
        if (dummyRenderers != null)
            return dummyRenderers;

        indent = NotEnoughUpdates.INSTANCE.manager.jsonToStack(null);
        dummyRenderers = new HashMap<>();
        /*try
        {
            dummyRenderers.put("Project - Bartender's Brewery", ItemStack.loadItemStackFromNBT(JsonToNBT.getTagFromJson("{id: \"minecraft:skull\",Count: 1b,tag: {overrideMeta: 1b,ench: [],HideFlags: 254,SkullOwner: {Id: \"b2026d74-7d79-41ba-9113-9eb7f80174a5\",hypixelPopulated: 1b,Properties: {textures: [{Value: \"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDY3MmM1N2Y0YzdiOWU5NjJiNDViNTVkZDdiZDc4ODY4ODBkN2VlZjI2ZGI2YzJjY2UwM2M4ZmY4YzQ4In19fQ==\"}]},Name: \"§b2026d74-7d79-41ba-9113-9eb7f80174a5\"},display: {Lore: [\"§8City Project\", \"\", \"§7Upgrade the Bartender's\", \"§7brewery, offering new\", \"§7drinks and a new tier of\", \"§7Zombie slayer.\", \"\", \"§7Total contributions: §b1,000,000\", \"§7You made: §b25 contributions\", \"\", \"§7Community progress:\", \"§a-------------------- §a§l100%!\", \"§7Stage: §e§lCURRENTLY BUILDING!\", \"\", \"§7This city improvement is\", \"§7undergoing its final steps and\", \"§7will be released very soon!\"],Name: \"§aBartender's Brewery\"},AttributeModifiers: []},Damage: 3s}")));
            dummyRenderers.put("  \u00a7aBuilding & Machinery", ItemStack.loadItemStackFromNBT(JsonToNBT.getTagFromJson("{id: \"minecraft:log\",Count: 1b,tag: {overrideMeta: 1b,display: {Lore: [\"§8Project Component #1\", \"\", \"§7The bartender is upgrading\", \"§7all his basic equipment!\", \"\", \"§7Global: §b335,073 contributions\"],Name: \"§aBuilding & Machinery\"},AttributeModifiers: []},Damage: 2s}")));
            dummyRenderers.put("  \u00a7aSugary Drinks", ItemStack.loadItemStackFromNBT(JsonToNBT.getTagFromJson("{id: \"minecraft:reeds\",Count: 1b,tag: {overrideMeta: 1b,display: {Lore: [\"§8Project Component #2\", \"\", \"§7Some nice refreshments,\", \"§7sodas and cocktails!\", \"\", \"§7Global: §b242,896 contributions\"],Name: \"§aSugary Drinks\"},AttributeModifiers: []},Damage: 0s}")));
            dummyRenderers.put("  \u00a7aSlavic Recipes", ItemStack.loadItemStackFromNBT(JsonToNBT.getTagFromJson("{id: \"minecraft:potato\",Count: 1b,tag: {overrideMeta: 1b,display: {Lore: [\"§8Project Component #3\", \"\", \"§7Experimenting with popular\", \"§7eastern drinks!\", \"\", \"§7Global: §b232,380 contributions\"],Name: \"§aSlavic Recipes\"},AttributeModifiers: []},Damage: 0s}")));
            dummyRenderers.put("  \u00a7aLabor", ItemStack.loadItemStackFromNBT(JsonToNBT.getTagFromJson("{id: \"minecraft:diamond\",Count: 1b,tag: {ench: [],overrideMeta: 1b,HideFlags: 254,display: {Lore: [\"§8Project Component #4\", \"\", \"§7Fund the crew setting up\", \"§7the upgrades.\", \"\", \"§7Global: §b189,677 contributions\"],Name: \"§aLabor\"},AttributeModifiers: []},Damage: 0s}")));

        } catch (NBTException e)
        {
            e.printStackTrace();
        }*/
        //dummyRenderers.put("Project - Bartender's Brewery", indent);
        dummyRenderers.put("  \u00a7aBuilding & Machinery", indent);
        dummyRenderers.put("  \u00a7aSugary Drinks", indent);
        dummyRenderers.put("  \u00a7aSlavic Recipes", indent);
        dummyRenderers.put("  \u00a7aLabor", indent);

        dummyRenderers.put("    \u00a7aEnchanted Birch Wood \u00a722\u00a7f/\u00a722", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("ENCHANTED_BIRCH_LOG")));
        dummyRenderers.put("    \u00a7aEnchanted Iron \u00a7c0\u00a7f/\u00a721", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("ENCHANTED_IRON")));
        dummyRenderers.put("    \u00a7aEnchanted Sugar \u00a7c16\u00a7f/\u00a7232", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("ENCHANTED_SUGAR")));
        dummyRenderers.put("    \u00a7fMagical Water Bucket \u00a7216\u00a7f/\u00a728", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("MAGICAL_WATER_BUCKET")));
        dummyRenderers.put("    \u00a7aEnchanted Potato \u00a7c60\u00a7f/\u00a7264", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("ENCHANTED_POTATO")));
        dummyRenderers.put("    \u00a7fMagical Water Bucket \u00a7216\u00a7f/\u00a728", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("MAGICAL_WATER_BUCKET")));
        dummyRenderers.put("    \u00a7aEnchanted Clownfish \u00a7c2\u00a7f/\u00a724", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("ENCHANTED_CLOWNFISH")));
        dummyRenderers.put("    \u00a7aEnchanted Melon \u00a7264\u00a7f/\u00a7264", NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("ENCHANTED_MELON")));

        return dummyRenderers;
    }

    public Project getDummyProject()
    {
        if (dummyProject != null)
            return dummyProject;
        dummyProject = new Project();
        dummyProject.name = "Project - Bartender's Brewery";
        dummyProject.contribs = new ArrayList<>();
        {
            Contribute cont = new Contribute();
            cont.name = "\u00a7aBuilding & Machinery";
            cont.components.add(new Component("\u00a7aEnchanted Birch Wood", 2));
            cont.components.add(new Component("\u00a7aEnchanted Iron", 1));
            dummyProject.contribs.add(cont);
        }
        {
            Contribute cont = new Contribute();
            cont.name = "\u00a7aSugary Drinks";
            cont.components.add(new Component("\u00a7aEnchanted Sugar", 32));
            cont.components.add(new Component("\u00a7fMagical Water Bucket", 8));
            dummyProject.contribs.add(cont);
        }
        {
            Contribute cont = new Contribute();
            cont.name = "\u00a7aSlavic Recipes";
            cont.components.add(new Component("\u00a7aEnchanted Potato", 64));
            cont.components.add(new Component("\u00a7fMagical Water Bucket", 8));
            dummyProject.contribs.add(cont);
        }
        {
            Contribute cont = new Contribute();
            cont.name = "\u00a7aLabor";
            cont.components.add(new Component("\u00a7aEnchanted Clownfish", 4));
            cont.components.add(new Component("\u00a7aEnchanted Melon", 64));
            cont.bitsReq = 100;
            dummyProject.contribs.add(cont);
        }
        return dummyProject;
    }

    @Override
    public void update()
    {
        if (!NotEnoughUpdates.INSTANCE.config.miscOverlays.cityProjectPinEnabled || !NotEnoughUpdates.INSTANCE.isOnSkyblock())
            return;

        if (Minecraft.getMinecraft().thePlayer == null) return;
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

        if (pin != null)
        {
            for (Contribute cont : pin.contribs)
                if (!cont.completed)
                {
                    for (Component comp : cont.components)
                    {
                        int count = 0;
                        for (ItemStack is : player.inventory.mainInventory)
                            if (is != null && is.hasDisplayName() && is.getDisplayName().equalsIgnoreCase(comp.name))
                                count += is.stackSize;
                        comp.current = count;
                    }

                }
        }
    }

    @Override
    public void updateFrequent()
    {
        overlayStrings.clear();

        if (pin == null)
            return;

        overlayStrings.add(pin.name);
        for (Contribute cont : pin.contribs)
        {
            overlayStrings.add("  " + cont.name + (cont.completed ? " \u00a72\u00a7l✓" : ""));
            if (!cont.completed)
                for (Component comp : cont.components)
                    overlayStrings.add("    " + comp.name + " " + (comp.current >= comp.req ? "\u00a72" : "\u00a7c")
                            + comp.current + "\u00a7f/\u00a72" + comp.req);
            if (cont.bitsReq != -1)
                overlayStrings.add("    \u00a7b" + cont.bitsReq + " Bits");
        }
    }

    @Override
    protected void renderLine(String line, Vector2f position, boolean dummy)
    {
        if (!NotEnoughUpdates.INSTANCE.config.miscOverlays.cityProjectPinDisplayItem)
            return;
        ItemStack icon = null;
        String clean = Utils.cleanColour(line);
        String beforeColon = clean.split(":")[0];

        HashMap<String, ItemStack> renderers = null;
        if (dummy)
        {
            //icon = NotEnoughUpdates.INSTANCE.manager.jsonToStack(NotEnoughUpdates.INSTANCE.manager.getItemInformation().get("GOD_POTION"));
            renderers = getDummyRenderers();
        } else
        {
            // Check dynamic map
        }
        if (renderers == null)
            return;

        icon = renderers.getOrDefault(line, null);
        if (icon != null)
            if (icon == indent)
            {
                position.x += 2;
            } else
            {
                GlStateManager.pushMatrix();
                GlStateManager.translate(position.x, position.y, 0);
                GlStateManager.scale(0.5f, 0.5f, 1f);
                Utils.drawItemStack(icon, 0, 0);
                GlStateManager.popMatrix();
            }
    }

    public class Project {
        // Must match colours, since the Confirm Contribution menu does too, if you change it change both
        public String                name;
        public ArrayList<Contribute> contribs;

        /**
         * Initialise an empty City Project - For dummy pin only
         */
        public Project()
        {
        }

        /**
         * Create a City Project from the City Project Inventory provided
         *
         * @param inv The City Project Inventory
         */
        public Project(IInventory inv)
        {
            contribs = new ArrayList<>();
            int currentCount = 0;

            for (int i = 0; i < inv.getSizeInventory(); i++)
            {
                ItemStack itemStack = inv.getStackInSlot(i);

                if (itemStack.getItem() == Items.dye)
                {

                    if (itemStack.getDisplayName().equalsIgnoreCase("\u00a7eContribute this component!"))
                    {

                        NBTTagList loreNbt = itemStack.getTagCompound().getCompoundTag("display").getTagList("Lore", 8);
                        boolean costFound = false;

                        for (int l = 0; l < loreNbt.tagCount(); l++)
                        {
                            String lore = ((NBTTagString) loreNbt.get(l)).getString();

                            if (!costFound && lore.equalsIgnoreCase("\u00a77Cost"))
                            {
                                costFound = true;
                                continue;
                            }

                            if (costFound)
                            {
                                if (contribs.get(currentCount) == null)
                                    contribs.add(new Contribute());
                                if (lore.isEmpty())
                                    break;
                                else
                                {
                                    if (lore.contains("Bits"))
                                        contribs.get(currentCount).bitsReq = Integer.parseInt(lore.split(" ")[0].replaceFirst("\u00a7b", ""));
                                    else
                                    {
                                        String[] split = lore.split(" ");
                                        Component c;
                                        if (split[split.length - 1].matches(".*\\d.*"))
                                        {
                                            String name = lore.substring(0, lore.length() - split[split.length - 1].length()).trim();
                                            String count = split[split.length - 1]
                                                    .split("x")[1];
                                            c = new Component(name, Integer.valueOf(count));
                                        } else
                                        {
                                            c = new Component(lore.trim(), 1);
                                        }
                                        contribs.get(currentCount).components.add(c);

                                    }
                                }
                            }
                        }
                        currentCount++;
                    } else if (itemStack.getDisplayName().equalsIgnoreCase("\u00a7aComponent Contributed!"))
                    {
                        contribs.get(currentCount).completed = true;
                        currentCount++;
                    }
                } else
                {
                    if (itemStack.getTagCompound() == null || itemStack.getTagCompound().getCompoundTag("display") == null || itemStack.getTagCompound().getCompoundTag("display").getTagList("Lore", 8) == null)
                        continue;
                    NBTTagList loreNbt = itemStack.getTagCompound().getCompoundTag("display").getTagList("Lore", 8);
                    if (loreNbt.get(0).toString().startsWith("\"\u00a78Project Component #"))
                    {
                        //int pos = Integer.parseInt(loreNbt.get(0).toString().substring("\u00a78Project Component #".length(), loreNbt.get(0).toString().length()-1));
                        Contribute contribute = new Contribute();
                        contribute.name = itemStack.getDisplayName();
                        contribs.add(contribute);
                    } else if (loreNbt.get(0).toString().equalsIgnoreCase("\"\u00a78City Project\""))
                        name = itemStack.getDisplayName();

                }
            }
        }

    }

    public class Contribute {
        public String               name;
        public boolean              completed  = false;
        public ArrayList<Component> components = new ArrayList<>();
        public int                  bitsReq    = -1;
        public ItemStack            render     = null;
    }

    public class Component {
        public int req, current;
        public String    name;
        public ItemStack render;

        public Component(String name, int req)
        {
            this(name, req, null);
        }

        public Component(String name, int req, ItemStack render)
        {
            this.name = name;
            this.req = req;
            if (render != null)
                this.render = render.copy();
        }
    }
}
