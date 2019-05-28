package jp.co.sample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {
	private AdministratorRepository administratorRepository
}
