

-- sql分析
-- 管理员账户只能由数据库管理员赋予
-- 学生和班级
-- 一个班有多个学生
-- 一个课可以被多个学生选

-- 删表
DROP TABLE
    IF
    EXISTS t_student_subject;
-- 	分割---
DROP TABLE
    IF
    EXISTS t_student;
-- 	分割---
DROP TABLE
    IF
    EXISTS t_grade;
-- 	分割---
DROP TABLE
    IF
    EXISTS t_subject;
-- 	分割---


-- 班级表
CREATE TABLE t_grade (
                         gid int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT'班级id',
                         gname VARCHAR(200) unique
);

-- 学生信息表
CREATE TABLE t_student (
                           sid int PRIMARY KEY  NOT NUll AUTO_INCREMENT COMMENT '学生学号',
                           sname VARCHAR(200) NOT NUll COMMENT '学生姓名',
                           stel VARCHAR(20) NOT NULL COMMENT '学生手机号',
                           sgid int NOT NULL COMMENT '学生班级',-- 外键对应的主键id
                           isadmin int DEFAULT 0 COMMENT '管理员1是0否',
                           CONSTRAINT stu_grade_fk0  FOREIGN KEY(sgid) REFERENCES t_grade (gid) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 课程表
CREATE TABLE t_subject (
                           subid int PRIMARY KEY  NOT NUll KEY AUTO_INCREMENT COMMENT '课程id',
                           subname VARCHAR(200) COMMENT '课程名称' unique
);

-- 中间表
CREATE TABLE t_student_subject (
                                   ssid INT AUTO_INCREMENT PRIMARY KEY,
                                   sid int COMMENT '学生id',
                                   subid int COMMENT '课程id',
                                   CONSTRAINT t_student_subject_sid_fk0 FOREIGN KEY(sid) REFERENCES t_student(sid) ON UPDATE CASCADE ON DELETE CASCADE,
                                   CONSTRAINT t_student_subject_subid_fk0 FOREIGN KEY(subid) REFERENCES t_subject(subid) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 插入班级信息
INSERT into t_grade (gname) VALUES ('一班'),('二班'),('三班'),('四班');
-- 插入学生信息
INSERT INTO t_student (sname,stel,sgid) VALUES ("李一","10010",1),("李二","10010",2),("李三","10010",3),("李四","10010",4),("李洋洋","10010",1),("杨逵","10010",1)
                                             ,("吴境","10010",2),("叶轩","10010",2),("杨逵","12310",2);
-- 插入课程信息
INSERT INTO t_subject (subname) VALUES ("ssm框架开发技术"),("操作系统"),("Mysql"),("数据结构"),("计算机网络");
-- 中间表
INSERT INTO t_student_subject (sid,subid) VALUES (1,2),(2,1),(3,3),(4,1),(1,1),(1,3),(2,5),(3,1),(4,2),(1,4),(1,5),(5,1);


-- admin
-- 1.	查询指定班级下所有学生信息，(一对多)
SELECT
    *
FROM
    t_grade g,
    t_student s
WHERE
        s.sgid = 1
  AND s.sgid = g.gid;
-- 2.	删除指定班级，以及该班级下所有学生（两个单表操作）
DELETE
FROM
    t_grade
WHERE
        gid = 1;
-- 3.	查询学习了指定课程下的所有学生信息（多对多）
SELECT
    sub.* ,stu.*
FROM
    t_subject sub,
    t_student_subject ss,
    t_student stu
WHERE
        stu.sid = ss.sid
  AND ss.subid = sub.subid
  AND sub.subname = "ssm框架开发技术";
-- 4.	删除指定课程，但是不删除学生信息 （单表）
DELETE from t_subject WHERE t_subject.subname="ssm框架开发技术";
-- 5.	添加班级
INSERT INTO t_grade (gname) VALUES ("五班");
-- 6.	添加课程
INSERT INTO t_subject (subname) VALUES ("python爬虫");
-- 7.	在指定班级下添加学生
INSERT INTO t_student (sname,stel,sgid) VALUES ("李洋洋","12345",1);
-- 8.	删除指定学生
DELETE from t_student WHERE t_student.sname="李洋洋";
-- 9.	修改指定学生信息
UPDATE t_student set stel="11111",sgid=2 WHERE sname="李洋洋";

-- ()


-- 学生功能
-- 1.	查询该学生所在班级信息
SELECT
    g.* ,s.*
FROM
    t_grade g, t_student s
WHERE
        s.sname="李洋洋" and s.sgid=g.gid;
-- 2.	查询该学生自己的所有学生信息
SELECT * FROM t_student s WHERE s.sname="李洋洋";
-- 3.	查询该学生选择学习的课程
SELECT * from t_student stu, t_subject sub,t_stu_subject WHERE stu
-- 4.	修改该学生的个人信息
UPDATE t_student s set stel="11111" WHERE s.sname="李洋洋" and s.sid=5;
