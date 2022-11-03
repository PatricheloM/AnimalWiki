package animalwiki.backend.service.impl;

import animalwiki.backend.repository.QueryRepository;
import animalwiki.backend.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    QueryRepository queryRepository;

    @Override
    public List<String> searchFor(String query) {
        return queryRepository.searchFor(query);
    }
}
