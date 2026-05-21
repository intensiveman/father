-- 创建学生信息表
CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生ID（主键）',
  `student_no` varchar(50) NOT NULL COMMENT '学号',
  `name` varchar(100) NOT NULL COMMENT '学生姓名',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别（0=女，1=男）',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `class_name` varchar(100) DEFAULT NULL COMMENT '班级名称',
  `major` varchar(100) DEFAULT NULL COMMENT '专业',
  `college` varchar(100) DEFAULT NULL COMMENT '学院',
  `enrollment_year` int(4) DEFAULT NULL COMMENT '入学年份',
  `status` tinyint(1) DEFAULT 1 COMMENT '状态（0=休学，1=在读，2=毕业，3=退学）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '软删除标记（0=正常，1=删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_student_no` (`student_no`),
  KEY `idx_name` (`name`),
  KEY `idx_class_name` (`class_name`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

-- 插入测试数据
INSERT INTO `student` (`student_no`, `name`, `gender`, `age`, `id_card`, `phone`, `email`, `address`, `class_name`, `major`, `college`, `enrollment_year`, `status`, `remark`) VALUES
('2021001', '张三', 1, 20, '110101200101011234', '13800138001', 'zhangsan@example.com', '北京市朝阳区', '计算机1班', '计算机科学与技术', '计算机学院', 2021, 1, '测试数据'),
('2021002', '李四', 0, 19, '110101200202022345', '13800138002', 'lisi@example.com', '上海市浦东新区', '计算机1班', '计算机科学与技术', '计算机学院', 2021, 1, '测试数据'),
('2021003', '王五', 1, 21, '110101200303033456', '13800138003', 'wangwu@example.com', '广州市天河区', '软件1班', '软件工程', '软件学院', 2021, 1, '测试数据'),
('2022001', '赵六', 0, 20, '110101200404044567', '13800138004', 'zhaoliu@example.com', '深圳市南山区', '计算机2班', '计算机科学与技术', '计算机学院', 2022, 1, '测试数据'),
('2022002', '孙七', 1, 19, '110101200505055678', '13800138005', 'sunqi@example.com', '杭州市西湖区', '软件2班', '软件工程', '软件学院', 2022, 1, '测试数据');
