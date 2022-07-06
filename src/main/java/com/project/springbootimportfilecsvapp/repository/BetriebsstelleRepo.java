package com.project.springbootimportfilecsvapp.repository;

import com.project.springbootimportfilecsvapp.entity.Betriebsstelle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetriebsstelleRepo extends JpaRepository<Betriebsstelle, Long> {
}
