package com.example.PHONGTROSPRING.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Listings")
public class Listings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

	@ManyToOne
	@JoinColumn(nullable = false, name = "userId", referencedColumnName = "userId")
	private User user;

	@Column(nullable = false, length = 100, columnDefinition = "varchar(255)")
	private String title;

	@Column(nullable = false, length = 500, columnDefinition = "varchar(255)")
	private String description;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal area;

	@ManyToOne
	@JoinColumn(nullable = false, name = "locationId", referencedColumnName = "locationId")
	private Locations location;

	@Column(nullable = false, columnDefinition = "varchar(255)")
	private String address;

	@ManyToOne
	@JoinColumn(nullable = false, name = "roomTypeId", referencedColumnName = "roomTypeId")
	private RoomTypes roomType;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = true)
	private LocalDateTime expiryDate;

	@Column(nullable = true)
	private LocalDateTime updatedAt;

	@Column(name = "postType")
	private int postType;

	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String status;

	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String object;

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(int vip) {
		if (vip == 5) {
			expiryDate = LocalDateTime.now().plusDays(5);
		}
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public RoomTypes getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypes roomType) {
		this.roomType = roomType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = LocalDateTime.now();
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt() {
		this.updatedAt = LocalDateTime.now();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		String statusTemp = "Chờ duyệt";

		if (status.equals("Đã duyệt")) {
			statusTemp = "Đã duyệt";
		} else if (status.equals("Chờ duyệt")) {
			statusTemp = "Chờ duyệt";
		} else if (status.equals("Ẩn tin")) {
			statusTemp = "Ẩn tin";
		}

		this.status = statusTemp;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		String objectTemp = "Tất cả";

		if (object.equals("Nam")) {
			objectTemp = "Nam";
		} else if (object.equals("Nữ")) {
			objectTemp = "Nữ";
		}

		this.object = objectTemp;
	}
}
