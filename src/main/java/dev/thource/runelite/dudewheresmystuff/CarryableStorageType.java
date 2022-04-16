package dev.thource.runelite.dudewheresmystuff;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.InventoryID;

@RequiredArgsConstructor
@Getter
public enum CarryableStorageType implements StorageType {
    INVENTORY("Inventory", InventoryID.INVENTORY.getId(), true),
    EQUIPMENT("Equipment", InventoryID.EQUIPMENT.getId(), true),
    LOOTING_BAG("Looting Bag", 516, false),
    SEED_BOX("Seed Box", 573, false),
    RUNE_POUCH("Rune Pouch", -1, true);

    private final String name;
    private final int itemContainerId;
    // Whether the storage can be updated with no action required by the player
    private final boolean automatic;
}
