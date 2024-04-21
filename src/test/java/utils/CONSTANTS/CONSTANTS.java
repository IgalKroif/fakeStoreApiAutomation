package utils.CONSTANTS;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CONSTANTS extends CONSTANT_VALIDATION {
    String dateFieldPattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z";
    String headerDatePattern = "\\p{Alpha}{3}, \\d{2} \\p{Alpha}{3} \\d{4} \\d{2}:\\d{2}:\\d{2} GMT";

    List<String> PRODUCT_NAMES = Arrays.asList(
            "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin",
            "BIYLACLESEN Women's 3-in-1 Snowboard Jacket Winter Coats",
            "DANVOUY Womens T Shirt Casual Cotton Short",
            "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
            "Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket",
            "MBJ Women's Solid Short Sleeve Boat Neck V",
            "Mens Casual Premium Slim Fit T-Shirts",
            "Mens Casual Slim Fit",
            "Mens Cotton Jacket",
            "Opna Women's Short Sleeve Moisture",
            "Pierced Owl Rose Gold Plated Stainless Steel Double",
            "Rain Jacket Women Windbreaker Striped Climbing Raincoats",
            "Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED",
            "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s",
            "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5",
            "Solid Gold Petite Micropave",
            "WD 2TB Elements Portable External Hard Drive - USB 3.0",
            "WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive",
            "White Gold Plated Princess"
    );
}
