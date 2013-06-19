package no.nav.sbl.demo.web.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NameServiceImpl implements NameService {

    public List<String> getNames() {
        return Arrays.asList("Anders", "Eivind", "Øyvind", "Magnus", "Holger", "Henrik");
    }
}
