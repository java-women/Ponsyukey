package javajo.ponsyukey.dto;

import java.util.List;

public record Sake(String id,
                   String name,
                   String image,
                   SakeBrewery sakeBrewery,
                   Float alcohol,
                   Float polishingRatio,
                   String type,
                   String description,
                   List<String> taste) {
}
