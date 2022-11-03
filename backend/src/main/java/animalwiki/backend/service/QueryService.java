package animalwiki.backend.service;

import java.util.List;

public interface QueryService {
    List<String> searchFor(String query);
}
