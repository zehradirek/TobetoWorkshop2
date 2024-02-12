package com.tobeto.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.personel.AdresYaratRequestDTO;
import com.tobeto.dto.personel.AdresYaratResponseDTO;
import com.tobeto.entity.Personel;
import com.tobeto.service.PersonelService;

@RestController
@RequestMapping("api/personel")
public class PersonelController {
	@Autowired
	private PersonelService personelService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping
	public AdresYaratResponseDTO personelYarat(@RequestBody AdresYaratRequestDTO dto) {
		Personel personel = requestMapper.map(dto, Personel.class);
		personelService.addPersonel(personel);
		return responseMapper.map(personel, AdresYaratResponseDTO.class);
	}
}