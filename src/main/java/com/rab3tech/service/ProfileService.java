package com.rab3tech.service;

import java.util.List;

import com.rab3tech.controller.dto.ProfileDTO;

public interface ProfileService {
	void show();

	String updateSignup(ProfileDTO profileDTO);

	String createSignup(ProfileDTO profileDTO);

	List<ProfileDTO> sortProfiles(String sort);

	List<String> findAllQualification();

	List<ProfileDTO> filterProfiles(String filterText);

	List<ProfileDTO> searchProfiles(String search);

	List<ProfileDTO> findAll();

	ProfileDTO authUser(String pusername, String ppassword);

	ProfileDTO findByEmail(String pemail);

	ProfileDTO findByUsername(String pusername);

	void deleteByUsername(String pusername);

	String findPasswordByUsernameOrEmail(String pusernameEmail);

	String icreateSignup(ProfileDTO profileDTO);

	byte[] findPhotoByUsername(String pusername);

	List<ProfileDTO> findAllWithPhoto();

	String updatePhoto(ProfileDTO profileDTO);
}
