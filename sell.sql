/*
 Navicat Premium Data Transfer

 Source Server         : 虚拟机mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 192.168.43.104:3306
 Source Schema         : sell

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 28/12/2019 13:29:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('123446', '123456', '123456', '皮蛋粥', 3.20, 1, 'http://xxx.jpg', '2019-11-17 08:58:54', '2019-11-17 08:58:54');
INSERT INTO `order_detail` VALUES ('1574181668490597704', '1574181668556752618', '123456', '皮蛋粥', 3.20, 2, 'http://xxx.jpg', '2019-11-17 17:31:58', '2019-11-17 17:31:58');
INSERT INTO `order_detail` VALUES ('1574263726071501121', '1574263726016875684', '123456', '皮蛋粥', 3.20, 3, 'http://xxx.jpg', '2019-11-17 21:17:37', '2019-11-17 21:17:37');
INSERT INTO `order_detail` VALUES ('1574493407779866127', '1574493407606701639', '123456', '皮蛋粥', 3.20, 2, 'http://xxx.jpg', '2019-11-23 07:16:47', '2019-11-23 07:16:47');
INSERT INTO `order_detail` VALUES ('1574671892795995214', '1574671892497180696', '123456', '皮蛋粥', 3.20, 1, 'http://xxx.jpg', '2019-11-23 21:25:57', '2019-11-23 21:25:57');
INSERT INTO `order_detail` VALUES ('1574685517335304587', '1574685517309866949', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-11-24 01:31:57', '2019-11-24 01:31:57');
INSERT INTO `order_detail` VALUES ('1574687996396470241', '1574687996377835912', '123456', '皮蛋粥', 3.20, 3, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-11-24 01:45:13', '2019-11-24 01:45:13');
INSERT INTO `order_detail` VALUES ('1574688470245133729', '1574688470235355049', '123457', '皮皮虾', 3.20, 4, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-11-24 01:53:46', '2019-11-24 01:53:46');
INSERT INTO `order_detail` VALUES ('1574688917821726851', '1574688917820139764', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-11-24 02:01:51', '2019-11-24 02:01:51');
INSERT INTO `order_detail` VALUES ('1574688917824839079', '1574688917820139764', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-11-24 02:01:51', '2019-11-24 02:01:51');
INSERT INTO `order_detail` VALUES ('1574689019619295321', '1574689019607992670', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-11-24 02:03:41', '2019-11-24 02:03:41');
INSERT INTO `order_detail` VALUES ('1574689728614996242', '1574689728612882718', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-11-24 02:16:29', '2019-11-24 02:16:29');
INSERT INTO `order_detail` VALUES ('1574689835174659853', '1574689835165432499', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-11-24 02:18:25', '2019-11-24 02:18:25');
INSERT INTO `order_detail` VALUES ('1574689835187831036', '1574689835165432499', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-11-24 02:18:25', '2019-11-24 02:18:25');
INSERT INTO `order_detail` VALUES ('1574737459326434723', '1574737459271865463', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-11-24 04:29:40', '2019-11-24 04:29:40');
INSERT INTO `order_detail` VALUES ('1574737459393659235', '1574737459271865463', '123457', '皮皮虾', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-11-24 04:29:40', '2019-11-24 04:29:40');
INSERT INTO `order_detail` VALUES ('1574737459401622156', '1574737459271865463', '123458', '豆芽炒饼', 5.80, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575277081&di=5669383931064eaef6a18693a558cfec&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.xssundama.com%2Fuploads%2Fimage%2F20180116%2F1516092162.jpg', '2019-11-24 04:29:40', '2019-11-24 04:29:40');
INSERT INTO `order_detail` VALUES ('1575710445010644991', '1575710444997622804', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-07 09:20:44', '2019-12-07 09:20:44');
INSERT INTO `order_detail` VALUES ('1575710445031492133', '1575710444997622804', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-07 09:20:44', '2019-12-07 09:20:44');
INSERT INTO `order_detail` VALUES ('1575948439961857959', '1575948439943710004', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 04:32:01', '2019-12-08 04:32:01');
INSERT INTO `order_detail` VALUES ('1575948439985740075', '1575948439943710004', '123457', '皮皮虾', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 04:32:01', '2019-12-08 04:32:01');
INSERT INTO `order_detail` VALUES ('1575948508112302125', '1575948508102372232', '123456', '皮蛋粥', 3.20, 3, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 04:33:15', '2019-12-08 04:33:15');
INSERT INTO `order_detail` VALUES ('1575948733223267167', '1575948733221325674', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 04:37:18', '2019-12-08 04:37:18');
INSERT INTO `order_detail` VALUES ('1575948733226756694', '1575948733221325674', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 04:37:18', '2019-12-08 04:37:18');
INSERT INTO `order_detail` VALUES ('1575949103005442273', '1575949103004274861', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 04:43:59', '2019-12-08 04:43:59');
INSERT INTO `order_detail` VALUES ('1575949210264203249', '1575949210263564887', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 04:45:55', '2019-12-08 04:45:55');
INSERT INTO `order_detail` VALUES ('1575949210269579069', '1575949210263564887', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 04:45:55', '2019-12-08 04:45:55');
INSERT INTO `order_detail` VALUES ('1575959156194957348', '1575959156179355141', '123456', '皮蛋粥', 3.20, 3, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 04:59:22', '2019-12-08 04:59:22');
INSERT INTO `order_detail` VALUES ('1575959365861243512', '1575959365846331848', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 05:03:09', '2019-12-08 05:03:09');
INSERT INTO `order_detail` VALUES ('1575959365884569538', '1575959365846331848', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 05:03:09', '2019-12-08 05:03:09');
INSERT INTO `order_detail` VALUES ('1575960001250721577', '1575960001232248305', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 05:14:38', '2019-12-08 05:14:38');
INSERT INTO `order_detail` VALUES ('1575960001274767856', '1575960001232248305', '123457', '皮皮虾', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 05:14:38', '2019-12-08 05:14:38');
INSERT INTO `order_detail` VALUES ('1575960167134947760', '1575960167132572870', '123456', '皮蛋粥', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 05:17:37', '2019-12-08 05:17:37');
INSERT INTO `order_detail` VALUES ('1575960167139771324', '1575960167132572870', '123457', '皮皮虾', 3.20, 1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 05:17:37', '2019-12-08 05:17:37');
INSERT INTO `order_detail` VALUES ('1575960923206279461', '1575960923204136470', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 05:26:49', '2019-12-08 05:26:49');
INSERT INTO `order_detail` VALUES ('1575960923210209314', '1575960923204136470', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 05:26:49', '2019-12-08 05:26:49');
INSERT INTO `order_detail` VALUES ('1575962291561966568', '1575962291541407858', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 05:51:32', '2019-12-08 05:51:32');
INSERT INTO `order_detail` VALUES ('1575962291588346425', '1575962291541407858', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 05:51:32', '2019-12-08 05:51:32');
INSERT INTO `order_detail` VALUES ('1575969231246977752', '1575969231197483129', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 06:34:24', '2019-12-08 06:34:24');
INSERT INTO `order_detail` VALUES ('1575969231331215185', '1575969231197483129', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 06:34:24', '2019-12-08 06:34:24');
INSERT INTO `order_detail` VALUES ('1575969360722345198', '1575969360720457475', '123456', '皮蛋粥', 3.20, 3, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 06:36:45', '2019-12-08 06:36:45');
INSERT INTO `order_detail` VALUES ('1575969971053246828', '1575969971049526090', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 06:47:46', '2019-12-08 06:47:46');
INSERT INTO `order_detail` VALUES ('1576023820838203601', '1576023820836142139', '123456', '皮蛋粥', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', '2019-12-08 07:38:42', '2019-12-08 07:38:42');
INSERT INTO `order_detail` VALUES ('1576023820843430961', '1576023820836142139', '123457', '皮皮虾', 3.20, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', '2019-12-08 07:38:42', '2019-12-08 07:38:42');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态, 默认未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('123456', '张三', '123456789123', '慕课网', '11011', 2.30, 2, 0, '2019-11-17 08:33:18', '2019-11-24 07:42:10');
INSERT INTO `order_master` VALUES ('1574263726016875684', '刘宇航', '1234566890', '慕网', 'ew3euwhd7sjw9diwkq', 9.60, 1, 0, '2019-11-17 21:17:37', '2019-11-17 22:24:10');
INSERT INTO `order_master` VALUES ('1574493407606701639', '张三', '18868822111', '慕课网总部', 'ew3euwhd7sjw9diwkq', 6.40, 2, 0, '2019-11-23 07:16:47', '2019-11-24 07:10:16');
INSERT INTO `order_master` VALUES ('1574671892497180696', '是多少', '1686486548', '河工', 'abc', 3.20, 2, 0, '2019-11-23 21:25:57', '2019-11-24 02:15:48');
INSERT INTO `order_master` VALUES ('1574685517309866949', '线程', '156', '5sa', 'abc', 6.40, 1, 0, '2019-11-24 01:31:57', '2019-11-24 10:43:18');
INSERT INTO `order_master` VALUES ('1574687996377835912', 'da', '446484564', 's', 'abc', 9.60, 1, 0, '2019-11-24 01:45:13', '2019-11-24 10:43:55');
INSERT INTO `order_master` VALUES ('1574688470235355049', '刘宇航', '13864689855', '河工', 'abc', 12.80, 0, 0, '2019-11-24 01:53:46', '2019-11-24 01:53:46');
INSERT INTO `order_master` VALUES ('1574688917820139764', 'sdfs', 'ddf', 'dd', 'abc', 12.80, 0, 0, '2019-11-24 02:01:51', '2019-11-24 02:01:51');
INSERT INTO `order_master` VALUES ('1574689019607992670', 'df', 'dfs', 'df', 'abc', 6.40, 2, 0, '2019-11-24 02:03:41', '2019-11-24 07:11:40');
INSERT INTO `order_master` VALUES ('1574689728612882718', '刘宇航', '18032140744', '河工', 'abc', 6.40, 2, 0, '2019-11-24 02:16:29', '2019-11-24 02:16:37');
INSERT INTO `order_master` VALUES ('1574689835165432499', '愈合', '18054895486', '很多事', 'abc', 9.60, 2, 1, '2019-11-24 02:18:25', '2019-11-24 02:18:45');
INSERT INTO `order_master` VALUES ('1574737459271865463', '李健建', '16885489548', '河工209', 'abc', 12.20, 2, 1, '2019-11-24 04:29:40', '2019-11-24 04:30:35');
INSERT INTO `order_master` VALUES ('1575710444997622804', '宋建华', '18033346845', '河工', 'abc', 9.60, 0, 1, '2019-12-07 09:20:44', '2019-12-07 09:20:44');
INSERT INTO `order_master` VALUES ('1575948439943710004', '刘宇航', '18032140711', '河工宿舍300', 'abc', 6.40, 0, 1, '2019-12-08 04:32:01', '2019-12-08 04:32:01');
INSERT INTO `order_master` VALUES ('1575948508102372232', '宋建华', '4456', '河工200', 'abc', 9.60, 2, 1, '2019-12-08 04:33:15', '2019-12-08 04:36:40');
INSERT INTO `order_master` VALUES ('1575948733221325674', '张飞', '18055564864', '小花园', 'abc', 9.60, 0, 1, '2019-12-08 04:37:18', '2019-12-08 04:37:18');
INSERT INTO `order_master` VALUES ('1575949103004274861', '马闯闯', '44895488', '河工', 'abc', 6.40, 2, 1, '2019-12-08 04:43:59', '2019-12-08 04:45:36');
INSERT INTO `order_master` VALUES ('1575949210263564887', 'ddf', '4648184', 'df', 'abc', 9.60, 2, 1, '2019-12-08 04:45:55', '2019-12-08 04:46:05');
INSERT INTO `order_master` VALUES ('1575959156179355141', '刘宇航', '18468453159', '石家庄桥西区', 'abc', 9.60, 0, 1, '2019-12-08 04:59:22', '2019-12-08 04:59:22');
INSERT INTO `order_master` VALUES ('1575959365846331848', '刘宇航', '124435332', '河工美食街', 'abc', 9.60, 0, 1, '2019-12-08 05:03:09', '2019-12-08 05:03:09');
INSERT INTO `order_master` VALUES ('1575960001232248305', '刘宇航', '75684658984', '河工', 'abc', 9.60, 2, 1, '2019-12-08 05:14:38', '2019-12-08 05:17:15');
INSERT INTO `order_master` VALUES ('1575960167132572870', '速度', '180654', '河工', 'abc', 6.40, 0, 1, '2019-12-08 05:17:37', '2019-12-08 05:17:37');
INSERT INTO `order_master` VALUES ('1575960923204136470', 'ABC', '1803334568', '成都府', 'abc', 12.80, 0, 1, '2019-12-08 05:26:49', '2019-12-08 05:26:49');
INSERT INTO `order_master` VALUES ('1575962291541407858', '宇航', '13056875654', '好好好', 'abc', 12.80, 0, 1, '2019-12-08 05:51:32', '2019-12-08 05:51:32');
INSERT INTO `order_master` VALUES ('1575969231197483129', '张三', '18034568', '河工', 'abc', 12.80, 2, 1, '2019-12-08 06:34:24', '2019-12-08 06:35:53');
INSERT INTO `order_master` VALUES ('1575969360720457475', '李四', '23141', '河工', 'abc', 9.60, 0, 1, '2019-12-08 06:36:45', '2019-12-08 06:36:45');
INSERT INTO `order_master` VALUES ('1575969971049526090', '张三', '1805456', '河工', 'abc', 6.40, 1, 1, '2019-12-08 06:47:46', '2019-12-08 06:48:23');
INSERT INTO `order_master` VALUES ('1576023820836142139', '刘宇航', '18032140713', '河工', 'abc', 12.80, 0, 1, '2019-12-08 07:38:42', '2019-12-08 07:38:42');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '热销', 4, '2019-12-06 11:05:26', '2019-12-06 11:05:26');
INSERT INTO `product_category` VALUES (2, '女生最爱', 3, '2019-12-06 10:27:50', '2019-12-06 10:27:50');
INSERT INTO `product_category` VALUES (5, '!!暖心外卖节!!', 2, '2019-12-06 10:27:44', '2019-12-06 10:27:44');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) NULL DEFAULT 0 COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123456', '皮蛋粥', 3.20, 77, '很好喝的粥', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682293123&di=58474e0d401596bc99d5c8594c4b1c43&imgtype=0&src=http%3A%2F%2Fpic.soutu123.cn%2Felement_origin_min_pic%2F16%2F12%2F02%2F01a27a9bce9346132bd7334ea1488b6c.jpg%2521%2Ffw%2F700%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue', 0, 4, '2019-12-03 09:06:12', '2019-12-08 07:38:42');
INSERT INTO `product_info` VALUES ('123457', '皮皮虾', 3.20, 78, '很好吃的虾', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574682333816&di=3658a6f85ee996877da7d7b8c134c762&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsr7JbhrhVUzvATCMPIDgIeRTkFAkjtMEDzeTob6E62pS01538046810120.jpeg', 0, 4, '2019-11-16 20:48:55', '2019-12-08 07:38:42');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info`  (
  `seller_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '微信openid',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`seller_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卖家信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1575896948448958880', 'admin', 'admin', 'abc', '2019-12-07 21:30:42', '2019-12-07 21:30:42');

SET FOREIGN_KEY_CHECKS = 1;
