package com.rab3tech.dao;

import java.util.List;

import com.rab3tech.dao.entity.ProfileEntity;

public interface ProfileDao {

	void show();

	String updateSignup(ProfileEntity profileDTO);

	String createSignup(ProfileEntity profileDTO);

	List<ProfileEntity> sortProfiles(String sort);

	List<String> findAllQualification();

	List<ProfileEntity> filterProfiles(String filterText);

	List<ProfileEntity> searchProfiles(String search);

	List<ProfileEntity> findAll();

	ProfileEntity authUser(String pusername, String ppassword);

	ProfileEntity findByEmail(String pemail);

	ProfileEntity findByUsername(String pusername);

	void deleteByUsername(String pusername);

	String findPasswordByUsernameOrEmail(String pusernameEmail);

	String icreateSignup(ProfileEntity profileDTO);

	byte[] findPhotoByUsername(String pusername);

	List<ProfileEntity> findAllWithPhoto();

	String updatePhoto(ProfileEntity profileDTO);

}
