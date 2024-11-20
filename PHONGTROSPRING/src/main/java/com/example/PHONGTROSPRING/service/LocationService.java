package com.example.PHONGTROSPRING.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PHONGTROSPRING.entities.Locations;
import com.example.PHONGTROSPRING.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public void addLocations() {
        List<Locations> locations = new ArrayList<>();
        
        locations.add(new Locations("Bình Định", "TP Quy Nhơn"));
        locations.add(new Locations("Bình Định", "TP Quy Nhơn"));
        locations.add(new Locations("Bình Định", "Huyện An Lão"));
        locations.add(new Locations("Bình Định", "Huyện Hoài Ân"));
        locations.add(new Locations("Bình Định", "Huyện Phù Mỹ"));
        locations.add(new Locations("Bình Định", "Huyện Tuy Phước"));
        locations.add(new Locations("Bình Định", "Huyện Vĩnh Thạnh"));

        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 1"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 2"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 3"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 4"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 5"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 6"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 7"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 8"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 9"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 10"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 11"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Quận 12"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Huyện Bình Chánh"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Huyện Cần Giờ"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Huyện Củ Chi"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Huyện Hóc Môn"));
        locations.add(new Locations("Thành phố Hồ Chí Minh", "Huyện Nhà Bè"));

        locations.add(new Locations("Hà Nội", "Quận Ba Đình"));
        locations.add(new Locations("Hà Nội", "Quận Hoàn Kiếm"));
        locations.add(new Locations("Hà Nội", "Quận Hai Bà Trưng"));
        locations.add(new Locations("Hà Nội", "Quận Đống Đa"));
        locations.add(new Locations("Hà Nội", "Quận Tây Hồ"));
        locations.add(new Locations("Hà Nội", "Quận Cầu Giấy"));
        locations.add(new Locations("Hà Nội", "Quận Thanh Xuân"));
        locations.add(new Locations("Hà Nội", "Quận Hà Đông"));
        locations.add(new Locations("Hà Nội", "Quận Long Biên"));
        locations.add(new Locations("Hà Nội", "Quận Bắc Từ Liêm"));
        locations.add(new Locations("Hà Nội", "Quận Nam Từ Liêm"));
        locations.add(new Locations("Hà Nội", "Huyện Ba Vì"));
        locations.add(new Locations("Hà Nội", "Huyện Chương Mỹ"));
        locations.add(new Locations("Hà Nội", "Huyện Đan Phượng"));
        locations.add(new Locations("Hà Nội", "Huyện Đông Anh"));
        locations.add(new Locations("Hà Nội", "Huyện Gia Lâm"));
        locations.add(new Locations("Hà Nội", "Huyện Hoài Đức"));
        locations.add(new Locations("Hà Nội", "Huyện Mê Linh"));
        locations.add(new Locations("Hà Nội", "Huyện Mỹ Đức"));
        locations.add(new Locations("Hà Nội", "Huyện Phú Xuyên"));
        locations.add(new Locations("Hà Nội", "Huyện Phúc Thọ"));
        locations.add(new Locations("Hà Nội", "Huyện Thanh Oai"));
        locations.add(new Locations("Hà Nội", "Huyện Thạch Thất"));
        locations.add(new Locations("Hà Nội", "Huyện Từ Liêm"));

        // Lưu tất cả dữ liệu vào database
        locationRepository.saveAll(locations);
    }
}
