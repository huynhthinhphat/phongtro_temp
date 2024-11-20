-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 19, 2024 lúc 06:51 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `phongtro`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog_posts`
--

CREATE TABLE `blog_posts` (
  `post_id` int(11) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `message` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact_support`
--

CREATE TABLE `contact_support` (
  `support_id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `message` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favorites`
--

CREATE TABLE `favorites` (
  `favorite_id` int(11) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `images`
--

CREATE TABLE `images` (
  `image_id` int(11) NOT NULL,
  `image_url` varchar(255) NOT NULL,
  `item_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `images`
--

INSERT INTO `images` (`image_id`, `image_url`, `item_id`) VALUES
(2, '/assets/images/imgRooms/anh1.jpg', 2),
(3, '/assets/images/imgRooms/anh2.jpg', 2),
(4, '/assets/images/imgRooms/anh3.jpg', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `listings`
--

CREATE TABLE `listings` (
  `item_id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `area` decimal(5,2) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `expiry_date` datetime(6) NOT NULL,
  `object` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `post_type` int(11) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `location_id` int(11) NOT NULL,
  `room_type_id` int(11) NOT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `listings`
--

INSERT INTO `listings` (`item_id`, `address`, `area`, `created_at`, `description`, `expiry_date`, `object`, `post_type`, `price`, `status`, `title`, `updated_at`, `location_id`, `room_type_id`, `user_id`) VALUES
(2, '15 đường Lê Duẩn', 20.50, '2024-11-18 14:27:26.000000', 'Phòng đẹp, có đầy đủ tiện nghi, gần trung tâm.', '2024-12-18 14:27:26.000000', 'Tất cả', 2, 3000000.00, 'Chờ duyệt', 'Phòng cho thuê gần hồ Hoàn Kiếm', '2024-11-18 14:27:26.000000', 1, 1, '53c5fcc8-cd81-43ef-a911-6bf48473f7eb'),
(3, '15 đường Lê Duẩn', 20.50, '2024-11-18 14:32:57.000000', 'Phòng đẹp, có đầy đủ tiện nghi, gần trung tâm.', '2024-11-23 14:32:57.000000', 'Tất cả', 2, 3000000.00, 'Chờ duyệt', 'Phòng cho thuê gần hồ Hoàn Kiếm', '2024-11-18 14:32:57.000000', 1, 1, '53c5fcc8-cd81-43ef-a911-6bf48473f7eb');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `locations`
--

CREATE TABLE `locations` (
  `location_id` int(11) NOT NULL,
  `city` varchar(255) NOT NULL,
  `district` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `locations`
--

INSERT INTO `locations` (`location_id`, `city`, `district`) VALUES
(1, 'Bình Định', 'TP Quy Nhơn'),
(2, 'Bình Định', 'TP Quy Nhơn'),
(3, 'Bình Định', 'Huyện An Lão'),
(4, 'Bình Định', 'Huyện Hoài Ân'),
(5, 'Bình Định', 'Huyện Phù Mỹ'),
(6, 'Bình Định', 'Huyện Tuy Phước'),
(7, 'Bình Định', 'Huyện Vĩnh Thạnh'),
(8, 'Thành phố Hồ Chí Minh', 'Quận 1'),
(9, 'Thành phố Hồ Chí Minh', 'Quận 2'),
(10, 'Thành phố Hồ Chí Minh', 'Quận 3'),
(11, 'Thành phố Hồ Chí Minh', 'Quận 4'),
(12, 'Thành phố Hồ Chí Minh', 'Quận 5'),
(13, 'Thành phố Hồ Chí Minh', 'Quận 6'),
(14, 'Thành phố Hồ Chí Minh', 'Quận 7'),
(15, 'Thành phố Hồ Chí Minh', 'Quận 8'),
(16, 'Thành phố Hồ Chí Minh', 'Quận 9'),
(17, 'Thành phố Hồ Chí Minh', 'Quận 10'),
(18, 'Thành phố Hồ Chí Minh', 'Quận 11'),
(19, 'Thành phố Hồ Chí Minh', 'Quận 12'),
(20, 'Thành phố Hồ Chí Minh', 'Huyện Bình Chánh'),
(21, 'Thành phố Hồ Chí Minh', 'Huyện Cần Giờ'),
(22, 'Thành phố Hồ Chí Minh', 'Huyện Củ Chi'),
(23, 'Thành phố Hồ Chí Minh', 'Huyện Hóc Môn'),
(24, 'Thành phố Hồ Chí Minh', 'Huyện Nhà Bè'),
(25, 'Hà Nội', 'Quận Ba Đình'),
(26, 'Hà Nội', 'Quận Hoàn Kiếm'),
(27, 'Hà Nội', 'Quận Hai Bà Trưng'),
(28, 'Hà Nội', 'Quận Đống Đa'),
(29, 'Hà Nội', 'Quận Tây Hồ'),
(30, 'Hà Nội', 'Quận Cầu Giấy'),
(31, 'Hà Nội', 'Quận Thanh Xuân'),
(32, 'Hà Nội', 'Quận Hà Đông'),
(33, 'Hà Nội', 'Quận Long Biên'),
(34, 'Hà Nội', 'Quận Bắc Từ Liêm'),
(35, 'Hà Nội', 'Quận Nam Từ Liêm'),
(36, 'Hà Nội', 'Huyện Ba Vì'),
(37, 'Hà Nội', 'Huyện Chương Mỹ'),
(38, 'Hà Nội', 'Huyện Đan Phượng'),
(39, 'Hà Nội', 'Huyện Đông Anh'),
(40, 'Hà Nội', 'Huyện Gia Lâm'),
(41, 'Hà Nội', 'Huyện Hoài Đức'),
(42, 'Hà Nội', 'Huyện Mê Linh'),
(43, 'Hà Nội', 'Huyện Mỹ Đức'),
(44, 'Hà Nội', 'Huyện Phú Xuyên'),
(45, 'Hà Nội', 'Huyện Phúc Thọ'),
(46, 'Hà Nội', 'Huyện Thanh Oai'),
(47, 'Hà Nội', 'Huyện Thạch Thất'),
(48, 'Hà Nội', 'Huyện Từ Liêm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room_types`
--

CREATE TABLE `room_types` (
  `room_type_id` int(11) NOT NULL,
  `room_type_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `room_types`
--

INSERT INTO `room_types` (`room_type_id`, `room_type_name`) VALUES
(1, 'Phòng trọ'),
(2, 'Nhà nguyên căn'),
(3, 'Căn hộ'),
(4, 'Mặt bằng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `status` varchar(255) NOT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `user_id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `balance` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`user_id`, `created_at`, `email`, `full_name`, `password`, `phone_number`, `role`, `balance`) VALUES
('53c5fcc8-cd81-43ef-a911-6bf48473f7eb', '2024-11-18 14:13:57.000000', 'user3@example.com', 'Phạm Minh D', '1', '1111111111', 'Tìm kiếm', 0.00),
('54c1d7d7-8753-47b8-b9e9-492e7d36ba23', '2024-11-18 14:13:57.000000', 'user1@example.com', 'Trần Thị B', 'password456', '0907654321', 'Tìm kiếm', 0.00),
('5afaaa46-0cea-4827-bf39-394f7aaa2187', '2024-11-18 14:13:57.000000', 'user2@example.com', 'Lê Quang C', 'password789', '0909876543', 'Tìm kiếm', 0.00),
('62765e5e-576a-4eb4-8cf0-e7deef5e054f', '2024-11-18 14:53:03.000000', NULL, 'Huỳnh Thịnh Phát', '11111111', '0375204559', 'Tìm kiếm', 0.00),
('9a8edff8-7509-479a-8454-b9b4421d3354', '2024-11-18 14:13:57.000000', 'admin@example.com', 'Nguyễn Văn A', 'password123', '0901234567', 'Quản trị viên', 0.00);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blog_posts`
--
ALTER TABLE `blog_posts`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `FK9bebj0jhg2mqq7ei9tsy3iwly` (`user_id`);

--
-- Chỉ mục cho bảng `contact_support`
--
ALTER TABLE `contact_support`
  ADD PRIMARY KEY (`support_id`),
  ADD KEY `FK6fxq3fsbv73pe0tvvor3sdhjh` (`user_id`);

--
-- Chỉ mục cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`favorite_id`),
  ADD KEY `FKk7du8b8ewipawnnpg76d55fus` (`user_id`),
  ADD KEY `FKl2v6kkuhlk0g7v7w88t16req2` (`item_id`);

--
-- Chỉ mục cho bảng `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `FKnq6rqwiavcl1582ni84tls8v` (`item_id`);

--
-- Chỉ mục cho bảng `listings`
--
ALTER TABLE `listings`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `FKln4xeugpsjbxxai34dv5eyqfw` (`location_id`),
  ADD KEY `FKawam5x9lb9b0l9ye8wbj11mno` (`room_type_id`),
  ADD KEY `FKb5kgkbggc40jyxeq28onih2x1` (`user_id`);

--
-- Chỉ mục cho bảng `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`location_id`);

--
-- Chỉ mục cho bảng `room_types`
--
ALTER TABLE `room_types`
  ADD PRIMARY KEY (`room_type_id`);

--
-- Chỉ mục cho bảng `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `FKqwv7rmvc8va8rep7piikrojds` (`user_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blog_posts`
--
ALTER TABLE `blog_posts`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `contact_support`
--
ALTER TABLE `contact_support`
  MODIFY `support_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `favorites`
--
ALTER TABLE `favorites`
  MODIFY `favorite_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `images`
--
ALTER TABLE `images`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `listings`
--
ALTER TABLE `listings`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `locations`
--
ALTER TABLE `locations`
  MODIFY `location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT cho bảng `room_types`
--
ALTER TABLE `room_types`
  MODIFY `room_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `blog_posts`
--
ALTER TABLE `blog_posts`
  ADD CONSTRAINT `FK9bebj0jhg2mqq7ei9tsy3iwly` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `contact_support`
--
ALTER TABLE `contact_support`
  ADD CONSTRAINT `FK6fxq3fsbv73pe0tvvor3sdhjh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `FKk7du8b8ewipawnnpg76d55fus` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKl2v6kkuhlk0g7v7w88t16req2` FOREIGN KEY (`item_id`) REFERENCES `listings` (`item_id`);

--
-- Các ràng buộc cho bảng `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `FKnq6rqwiavcl1582ni84tls8v` FOREIGN KEY (`item_id`) REFERENCES `listings` (`item_id`);

--
-- Các ràng buộc cho bảng `listings`
--
ALTER TABLE `listings`
  ADD CONSTRAINT `FKawam5x9lb9b0l9ye8wbj11mno` FOREIGN KEY (`room_type_id`) REFERENCES `room_types` (`room_type_id`),
  ADD CONSTRAINT `FKb5kgkbggc40jyxeq28onih2x1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKln4xeugpsjbxxai34dv5eyqfw` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`);

--
-- Các ràng buộc cho bảng `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `FKqwv7rmvc8va8rep7piikrojds` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
