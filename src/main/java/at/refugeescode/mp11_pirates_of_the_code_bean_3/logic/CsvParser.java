package at.refugeescode.mp11_pirates_of_the_code_bean_3.logic;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvParser {

    private ResourceLoader resourceLoader;

    public CsvParser(DefaultResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public <T> List<T> asList(CsvParserModule<T> module) {
        Resource resource = resourceLoader.getResource(module.getPath());
        try {
            return Files.lines(resource.getFile().toPath())
                    .skip(1)
                    .map(line -> line.split(";"))
                    .filter(module::isValid)
                    .map(module::toObject)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
