package com.rab3tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.controller.dto.ProfileDTO;
import com.rab3tech.dao.ProfileDao;
import com.rab3tech.dao.entity.ProfileEntity;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;

	@Override
	public void show() {
		
	}

	@Override
	public String updateSignup(ProfileDTO profileDTO) {
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(profileDTO, entity);
		String result=profileDao.updateSignup(entity);
		return result;
	}

	@Override
	public String createSignup(ProfileDTO profileDTO) {
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(profileDTO, entity);
		String result=profileDao.createSignup(entity);
		return result;
	}

	@Override
	public List<ProfileDTO> sortProfiles(String sort) {
		List<ProfileEntity> list=profileDao.sortProfiles(sort);
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}
	
	private List<ProfileDTO> convertList(List<ProfileEntity> list){
		List<ProfileDTO> profileDTOs=new ArrayList<ProfileDTO>();
		for(ProfileEntity entity:list){
			ProfileDTO profileDTO=new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
			profileDTOs.add(profileDTO);
		}
		return profileDTOs;
	}

	@Override
	public List<String> findAllQualification() {
		return profileDao.findAllQualification();
	}

	@Override
	public List<ProfileDTO> filterProfiles(String filterText) {
		List<ProfileEntity> list=profileDao.filterProfiles(filterText);
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	@Override
	public List<ProfileDTO> searchProfiles(String search) {
		List<ProfileEntity> list=profileDao.searchProfiles(search);
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	@Override
	public List<ProfileDTO> findAll() {
		List<ProfileEntity> list=profileDao.findAll();
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	@Override
	public ProfileDTO authUser(String pusername, String ppassword) {
		ProfileEntity profileEntity=profileDao.authUser(pusername, ppassword);
		ProfileDTO profileDTO=new ProfileDTO();
		BeanUtils.copyProperties(profileEntity, profileDTO);
		return profileDTO;
	}

	@Override
	public ProfileDTO findByEmail(String pemail) {
		ProfileEntity profileEntity=profileDao.findByEmail(pemail);
		ProfileDTO profileDTO=new ProfileDTO();
		BeanUtils.copyProperties(profileEntity, profileDTO);
		return profileDTO;
	}

	@Override
	public ProfileDTO findByUsername(String pusername) {
		ProfileEntity profileEntity=profileDao.findByUsername(pusername);
		ProfileDTO profileDTO=new ProfileDTO();
		BeanUtils.copyProperties(profileEntity, profileDTO);
		return profileDTO;
	}

	@Override
	public void deleteByUsername(String pusername) {
		profileDao.deleteByUsername(pusername);
	}

	@Override
	public String findPasswordByUsernameOrEmail(String pusernameEmail) {
		return 	profileDao.findPasswordByUsernameOrEmail(pusernameEmail);
	}

	@Override
	public String icreateSignup(ProfileDTO profileDTO) {
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(profileDTO, entity);
		String result =  profileDao.icreateSignup(entity);
		return result;
	}

	@Override
	public byte[] findPhotoByUsername(String pusername) {
		return profileDao.findPhotoByUsername(pusername);
	}

	@Override
	public List<ProfileDTO> findAllWithPhoto() {
		List<ProfileEntity> list=profileDao.findAllWithPhoto();
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	@Override
	public String updatePhoto(ProfileDTO profileDTO) {
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(profileDTO, entity);
		return profileDao.updatePhoto(entity);
	}

}