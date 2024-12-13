package com.example.PHONGTROSPRING.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PHONGTROSPRING.entities.*;
import com.example.PHONGTROSPRING.repository.*;

@Service
public class addLocationService {

	@Autowired
	private LocationsCityRepository cityRepo;

	@Autowired
	private LocationsDistrictRepository districtRepo;

	@Autowired
	private LocationsWardRepository wardRepo;

	public String addCity(String city) {

		LocationsCity newCity = new LocationsCity();

		if (!cityRepo.findByCity("Thành phố Hồ Chí Minh").isPresent()
				|| !cityRepo.findByCity("Thành phố Hà Nội").isPresent()
				|| !cityRepo.findByCity("Tỉnh Bình Định").isPresent()) {
			newCity.setCity(city);
		}

		if (cityRepo.findByCity("Thành phố Hồ Chí Minh").isPresent()
				|| cityRepo.findByCity("Thành phố Hà Nội").isPresent()
				|| cityRepo.findByCity("Tỉnh Bình Định").isPresent()) {
			return city + " đã tồn tại";
		}

		return cityRepo.save(newCity) != null ? "Thành công" : "Thất bại";
	}

	public String saveDisctrict(String cityName, String district) {

		Optional<LocationsCity> city = cityRepo.findByCity(cityName);

		if (city.isPresent()) {
			if (!districtRepo.findByDistrict(district).isPresent()) {

				LocationsDistrict newDistrict = new LocationsDistrict();
				newDistrict.setDistrict(district);

				LocationsCity cityCurrent = city.get();
				newDistrict.setLocation_city(cityCurrent);

				districtRepo.save(newDistrict);

				return "Thành công";
			}
			return "Đã có district";
		}
		return "Không có city";
	}

	public String saveWard(String districtName, String wardName) {

		Optional<LocationsDistrict> district = districtRepo.findByDistrict(districtName);

		if (district.isPresent()) {

			if (!wardRepo.findByWard(wardName).isPresent()) {
				LocationsDistrict districCurrent = district.get();

				LocationsWard ward = new LocationsWard();

				ward.setWard(wardName);
				ward.setLocation_district(districCurrent);

				wardRepo.save(ward);

				return "Thành công";
			}
			return "Đã có ward";
		}
		return "Không có district";
	}
}
