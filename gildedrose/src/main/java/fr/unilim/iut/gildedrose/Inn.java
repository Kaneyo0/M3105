package fr.unilim.iut.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
  private List<Item> items;

  public Inn() {
    items = new ArrayList<Item>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));
  }

  public List<Item> getItems() {
    return items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.size(); i++) {
      if (!items.get(i).getName().equals("Aged Brie") && !items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (qualitéItem(i) > 0) {
          if (!items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
            items.get(i).setQuality(qualitéItem(i) - 1);
          }
        }
      } else {
        if (qualitéItem(i) < 50) {
          items.get(i).setQuality(qualitéItem(i) + 1);

          if (items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items.get(i).getSellIn() < 11) {
              if (qualitéItem(i) < 50) {
                items.get(i).setQuality(qualitéItem(i) + 1);
              }
            }

            if (items.get(i).getSellIn() < 6) {
              if (qualitéItem(i) < 50) {
                items.get(i).setQuality(qualitéItem(i) + 1);
              }
            }
          }
        }
      }

      if (!items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
      }

      if (items.get(i).getSellIn() < 0) {
        if (!items.get(i).getName().equals("Aged Brie")) {
          if (!items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (qualitéItem(i) > 0) {
              if (!items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                items.get(i).setQuality(qualitéItem(i) - 1);
              }
            }
          } else {
            items.get(i).setQuality(qualitéItem(i) - qualitéItem(i));
          }
        } else {
          if (qualitéItem(i) < 50) {
            items.get(i).setQuality(qualitéItem(i) + 1);
          }
        }
      }
    }

  }

private int qualitéItem(int i) {
	return items.get(i).getQuality();
}
}