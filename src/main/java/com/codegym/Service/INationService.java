package com.codegym.Service;

import com.codegym.Model.Nation;

import java.util.List;

public interface INationService {
    List<Nation> getAllNation();

    Nation addNation(Nation nation);

    Nation findNationById(Long id);

    Nation updateNation(Nation nation);

    void removeNation(Nation nation);
}
