package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.olxapplication.dto.OlxDto;
import com.zensar.olxapplication.entity.Olx;
import com.zensar.olxapplication.repository.OlxLoginRepository;


@Service
public class OlxServiceImpl implements OlxService {
	@Autowired
	private OlxLoginRepository olxRepository;
	
	//private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	private ModelMapper modelMapper;

	Olx olx = new Olx();
	
	  //static List<Olx> userDetails = new ArrayList<Olx>();
	  
	 // static { userDetails.add(new Olx(1, "Ankita", "Ghodake", "ankitag",
	 // "ankita@97", "ankita25897@gmail.com", 9985278789L)); }
	

	@Override
	public List<OlxDto> getAllUser( int pageNumber, int pageSize ) {
		Page<Olx> listOlx = olxRepository.findAll( PageRequest.of(pageNumber, pageSize) );
		List<Olx> page = listOlx.getContent();

		List<OlxDto> olxResponses = new ArrayList<>();

		for (Olx olx :page ) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			OlxDto response=modelMapper.map(olx, OlxDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	

	@Override
	public String signInDetails(String userName, String password, String token) {
		olx.setUserName("ankitag");
		olx.setPassword("ankita123");
		if (token.equals("mj66453")) {
			if (olx.getUserName().equals("ankitag") && olx.getPassword().equals("ankita123")) {
				return "Login Successfull!!!";
			} else {
				return "Sorry, Authentication Failed!!!";
			}
		}
		return "Token is not valid";

	}

	@Override
	public OlxDto createOlxUser(OlxDto olxRequest, String token) {
		
      Olx newOlx= modelMapper.map(olxRequest, Olx.class);
		

		if (token.equals("ag66543")) {
			 Olx olx1 = olxRepository.save(newOlx);
			return modelMapper.map(olx1, OlxDto.class);

		} else {
			return null;
		}
	}

	@Override
	public String deleteUser(int userId) {
		
		olxRepository.deleteById(userId);
		return "User info deleted with : "+userId;
		/*
		 * for (Olx olx : userDetails) { if (olx.getUserId() == userId) {
		 * userDetails.remove(olx); return "user deleted Successfully" + userId; } }
		 * return "Sorry user is not available";
		 */

	}

	/*
	 * private Olx mapToOlx(OlxRequest olxRequest) {
	 * 
	 * Olx newOlx = new Olx(); newOlx.setUserId(olxRequest.getUserId());
	 * 
	 * newOlx.setFirstName(olxRequest.getFirstName());
	 * 
	 * newOlx.setLastName(olxRequest.getLastName());
	 * 
	 * newOlx.setUserName(olxRequest.getUserName());
	 * newOlx.setPassword(olxRequest.getPassword());
	 * newOlx.setEmialId(olxRequest.getEmialId());
	 * newOlx.setMobileNo(olxRequest.getMobileNo()); return newOlx; }
	 * 
	 * private Olx mapToOlx(OlxResponse olx) {
	 * 
	 * Olx newOlx = new Olx();
	 * 
	 * newOlx.setUserId(olx.getUserId());
	 * 
	 * newOlx.setFirstName(olx.getFirstName());
	 * 
	 * newOlx.setLastName(olx.getLastName());
	 * 
	 * newOlx.setUserName(olx.getUserName()); newOlx.setPassword(olx.getPassword());
	 * newOlx.setEmialId(olx.getEmialId()); newOlx.setMobileNo(olx.getMobileNo());
	 * 
	 * return newOlx;
	 * 
	 * }
	 */

	private OlxDto mapToResponse(Olx olx) {

		OlxDto olxResponse = new OlxDto();

		olxResponse.setUserId(olx.getUserId());

		olxResponse.setFirstName(olx.getFirstName());

		olxResponse.setLastName(olx.getLastName());

		olxResponse.setUserName(olx.getUserName());
		olxResponse.setPassword(olx.getPassword());
		olxResponse.setEmialId(olx.getEmialId());
		olxResponse.setMobileNo(olx.getMobileNo());
		return olxResponse;

	}

}
