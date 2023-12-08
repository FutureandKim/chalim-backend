package com.chalim.backend.service;

import com.chalim.backend.dto.translate.ResponseDto;
import com.chalim.backend.dto.translate.TextData;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class TranslateService {
    // 사용자 홈 디렉토리 내의 'images' 폴더에 이미지 저장
    private final Path imageStoragePath = Paths.get(System.getProperty("user.home"), "images");

    public ResponseDto translateTextData(String language, String imageName, MultipartFile imageFile) {
        try {
            if (imageFile.isEmpty()) {
                throw new IllegalArgumentException("Empty image file received");
            }

            // 'images' 폴더가 없다면 생성
            if (!Files.exists(imageStoragePath)) {
                Files.createDirectories(imageStoragePath);
            }

            Path imagePath = storeImage(imageFile, imageName);

            String dummyJson = "[\n" +
                    "    {\n" +
                    "        \"transcription\": \"노랑봉투감자\",\n" +
                    "        \"points\": [[1209, 1833], [1660, 1833], [1660, 1933], [1209, 1933]]\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"transcription\": \"7274\",\n" +
                    "        \"points\": [[331, 1425], [703, 1416], [704, 1471], [332, 1480]]\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"transcription\": \"775\",\n" +
                    "        \"points\": [[1490, 2192], [1677, 2192], [1677, 2221], [1490, 2221]]\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"transcription\": \"8000\",\n" +
                    "        \"points\": [[1221, 2267], [1387, 2267], [1387, 2329], [1221, 2329]]\n" +
                    "    }\n" +
                    "]";
            ObjectMapper objectMapper = new ObjectMapper();

            List<TextData> textDataList = objectMapper.readValue(dummyJson, new TypeReference<List<TextData>>() {
            });
            return new ResponseDto(imageName, textDataList);
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

};