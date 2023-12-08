
package com.chalim.backend.service;
import com.chalim.backend.dto.translate.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TranslateService {
    private final Path imageStoragePath = Paths.get(System.getProperty("user.home"), "images");

    public ResponseDto translateTextData(String language, String imageName, MultipartFile imageFile) {
        try {
            if (imageFile.isEmpty()) {
                throw new IllegalArgumentException("Empty image file received");
            }

            if (!Files.exists(imageStoragePath)) {
                Files.createDirectories(imageStoragePath);
            }

            Path imagePath = storeImage(imageFile, imageName);

            String dummyJson = "{\n" +
                    "    \"imageName\": \"20231208_213413.jpg\",\n" +
                    "    \"menuName\": [\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [389, 297],\n" +
                    "                [1552, 320],\n" +
                    "                [1549, 463],\n" +
                    "                [386, 440]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Japanese style set menu for 1 person\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [374, 584],\n" +
                    "                [898, 584],\n" +
                    "                [898, 735],\n" +
                    "                [374, 735]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Direct fire meat\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [367, 911],\n" +
                    "                [886, 921],\n" +
                    "                [883, 1072],\n" +
                    "                [364, 1062]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Soy sauce meat\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [354, 1247],\n" +
                    "                [1139, 1261],\n" +
                    "                [1136, 1408],\n" +
                    "                [351, 1394]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Gkotjeongsalgrilled\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [359, 1591],\n" +
                    "                [1320, 1614],\n" +
                    "                [1316, 1761],\n" +
                    "                [355, 1738]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Grilled Chicken and Chicken\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [354, 1940],\n" +
                    "                [1294, 1958],\n" +
                    "                [1291, 2092],\n" +
                    "                [351, 2074]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Grilled Chicken Maran\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [349, 2267],\n" +
                    "                [1294, 2281],\n" +
                    "                [1291, 2424],\n" +
                    "                [347, 2410]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Salt-grilled chicken\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [350, 2591],\n" +
                    "                [1285, 2609],\n" +
                    "                [1282, 2752],\n" +
                    "                [347, 2733]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Seasoned grilled chicken\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [359, 2918],\n" +
                    "                [1281, 2937],\n" +
                    "                [1278, 3080],\n" +
                    "                [356, 3061]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Chicken teriyaki\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [367, 3233],\n" +
                    "                [869, 3243],\n" +
                    "                [866, 3390],\n" +
                    "                [364, 3380]\n" +
                    "            ],\n" +
                    "            \"transcription\": \"Fire Squid\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"price\": [\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [2071, 611],\n" +
                    "                [2579, 632],\n" +
                    "                [2573, 783],\n" +
                    "                [2064, 763]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"9500\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [2065, 939],\n" +
                    "                [2579, 955],\n" +
                    "                [2574, 1106],\n" +
                    "                [2060, 1091]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"9500\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1993, 1281],\n" +
                    "                [2577, 1281],\n" +
                    "                [2577, 1428],\n" +
                    "                [1993, 1428]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"11000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1976, 1630],\n" +
                    "                [2556, 1630],\n" +
                    "                [2556, 1777],\n" +
                    "                [1976, 1777]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"11000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1969, 1956],\n" +
                    "                [2557, 1966],\n" +
                    "                [2554, 2113],\n" +
                    "                [1967, 2103]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"10000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [2835, 1995],\n" +
                    "                [3023, 1995],\n" +
                    "                [3023, 2121],\n" +
                    "                [2835, 2121]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"12\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1963, 2289],\n" +
                    "                [2543, 2289],\n" +
                    "                [2543, 2436],\n" +
                    "                [1963, 2436]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"10000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1963, 2612],\n" +
                    "                [2526, 2612],\n" +
                    "                [2526, 2759],\n" +
                    "                [1963, 2759]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"10000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1949, 2941],\n" +
                    "                [2502, 2931],\n" +
                    "                [2505, 3078],\n" +
                    "                [1952, 3088]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"10000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [1928, 3264],\n" +
                    "                [2490, 3254],\n" +
                    "                [2492, 3385],\n" +
                    "                [1930, 3394]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"11000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"points\": [\n" +
                    "                [2852, 3335],\n" +
                    "                [2994, 3335],\n" +
                    "                [2994, 3406],\n" +
                    "                [2852, 3406]\n" +
                    "            ],\n" +
                    "            \"priceValue\": \"10\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            ;

            ObjectMapper objectMapper = new ObjectMapper();
            ResponseDto responseDto = objectMapper.readValue(dummyJson, ResponseDto.class);
            return responseDto;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Path storeImage(MultipartFile imageFile, String imageName) throws IOException {
        Path imagePath = imageStoragePath.resolve(imageName);
        Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
        return imagePath;
    }
}
