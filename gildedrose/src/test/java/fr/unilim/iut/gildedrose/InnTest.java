package fr.unilim.iut.gildedrose;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class InnTest {
  @Test
  public void should_list_items() {
	  assertThat(new Inn().getItems()).extracting("name").containsExactly(
			  	"+5 Dexterity Vest",
			    "Aged Brie",
			    "Elixir of the Mongoose",
			    "Sulfuras, Hand of Ragnaros",
			    "Backstage passes to a TAFKAL80ETC concert",
			    "Conjured Mana Cake"
	  );
	  assertThat(new Inn().getItems()).extracting("sellIn").containsExactly(10, 2, 5, 0, 15, 3);
	  assertThat(new Inn().getItems()).extracting("quality").containsExactly(20, 0, 7, 80, 20, 6);
  } 
  
  @Test
  public void should_update_quality() {
	 Inn inn = new Inn();
	 inn.updateQuality();
	 assertThat(inn.getItems()).extracting("name").containsExactly(
			  	"+5 Dexterity Vest",
			    "Aged Brie",
			    "Elixir of the Mongoose",
			    "Sulfuras, Hand of Ragnaros",
			    "Backstage passes to a TAFKAL80ETC concert",
			    "Conjured Mana Cake"
	  );
	  assertThat(inn.getItems()).extracting("sellIn").containsExactly(9, 1, 4, 0, 14, 2);
	  assertThat(inn.getItems()).extracting("quality").containsExactly(19, 1, 6, 80, 21, 5);
  } 
  
  @Test
  public void should_update_quality_twice() {
	  Inn inn = new Inn();
	  inn.updateQuality();
	  inn.updateQuality();
	  assertThat(inn.getItems()).extracting("name").containsExactly(
			  	"+5 Dexterity Vest",
			    "Aged Brie",
			    "Elixir of the Mongoose",
			    "Sulfuras, Hand of Ragnaros",
			    "Backstage passes to a TAFKAL80ETC concert",
			    "Conjured Mana Cake"
	  );
	  assertThat(inn.getItems()).extracting("sellIn").containsExactly(8, 0, 3, 0, 13, 1);
	  assertThat(inn.getItems()).extracting("quality").containsExactly(18, 2, 5, 80, 22, 4);
  }
  
  @Test
  public void should_update_quality_thrice() {
	  Inn inn = new Inn();
	  inn.updateQuality();
	  inn.updateQuality();
	  inn.updateQuality();
	  assertThat(inn.getItems()).extracting("name").containsExactly(
			  	"+5 Dexterity Vest",
			    "Aged Brie",
			    "Elixir of the Mongoose",
			    "Sulfuras, Hand of Ragnaros",
			    "Backstage passes to a TAFKAL80ETC concert",
			    "Conjured Mana Cake"
	  );
	  assertThat(inn.getItems()).extracting("sellIn").containsExactly(7, -1, 2, 0, 12, 0);
	  assertThat(inn.getItems()).extracting("quality").containsExactly(17, 4, 4, 80, 23, 3);
  }
  
  @Test
  public void should_update_quality_four_times() {
	  Inn inn = new Inn();
	  inn.updateQuality();
	  inn.updateQuality();
	  inn.updateQuality();
	  inn.updateQuality();
	  assertThat(inn.getItems()).extracting("name").containsExactly(
			  	"+5 Dexterity Vest",
			    "Aged Brie",
			    "Elixir of the Mongoose",
			    "Sulfuras, Hand of Ragnaros",
			    "Backstage passes to a TAFKAL80ETC concert",
			    "Conjured Mana Cake"
	  );
	  assertThat(inn.getItems()).extracting("sellIn").containsExactly(6, -2, 1, 0, 11, -1);
	  assertThat(inn.getItems()).extracting("quality").containsExactly(16, 6, 3, 80, 24, 1);
  }
  
  @Test
  public void should_update_quality_a_lot() {
	  Inn inn = new Inn();
	  for (int day = 0; day<100; day++) {
		  inn.updateQuality();
	  }
	  assertThat(inn.getItems()).extracting("name").containsExactly(
			  	"+5 Dexterity Vest",
			    "Aged Brie",
			    "Elixir of the Mongoose",
			    "Sulfuras, Hand of Ragnaros",
			    "Backstage passes to a TAFKAL80ETC concert",
			    "Conjured Mana Cake"
	  );
	  assertThat(inn.getItems()).extracting("sellIn").containsExactly(-90, -98, -95, 0, -85, -97);
	  assertThat(inn.getItems()).extracting("quality").containsExactly(0, 50, 0, 80, 0, 0);
  }
  
  @Test
  public void should_test_against_legacy_code() {
	  LegacyInn legacyInn = new LegacyInn();
	  Inn inn = new Inn();
	  
	  for (int day = 0; day < 1000; day++) {
		  List<Item> items = inn.getItems();
		  List<Item> legacyItems = legacyInn.getItems();

		  assertThat(items).hasSize(legacyItems.size());
		  for (int i = 0; i < legacyItems.size(); i++) {
			  Item item = items.get(i);
			  Item legacyItem = legacyItems.get(i);
			  
			  assertThat(item.getName()).isEqualTo(legacyItem.getName());
			  assertThat(item.getQuality()).isEqualTo(legacyItem.getQuality());
			  assertThat(item.getSellIn()).isEqualTo(legacyItem.getSellIn());
		  }
		  
		  inn.updateQuality();
		  legacyInn.updateQuality();
	  }
  }
}