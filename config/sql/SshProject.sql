-- 部门表
create table ssh_department(
  -- 部门id
  id number(10) constraint dept_FK primary key,
  -- 部门名称
  department_name varchar2(50)
);

-- 员工表
create table ssh_employee(
  -- 员工id
  id number(10) constraint emp_PK primary key,
  -- 员工姓名
  last_name varchar2(50),
  -- 员工邮箱
  email varchar2(50),
  -- 员工生日
  birth date,
  -- 创建时间
  create_time date,
  -- 部门外键
  dept_id number(10) constraint emp_FK references ssh_department(id)
);

insert into ssh_department values(1,'销售部');
insert into ssh_department values(2,'信息部');
insert into ssh_department values(3,'人事部');
insert into ssh_department values(4,'财务部');
insert into ssh_department values(5,'信贷部');
insert into ssh_department values(6,'后勤部');

insert into ssh_employee values(1,'张三','zs@163.com','15-2月-89','31-3月-15',1);
insert into ssh_employee values(2,'李四','ls@163.com','23-7月-90','31-3月-15',3);
insert into ssh_employee values(3,'王五','ww@163.com','02-5月-88','31-3月-15',4);
insert into ssh_employee values(4,'赵六','zl@163.com','30-9月-90','31-3月-15',2);
insert into ssh_employee values(5,'周七','zq@163.com','19-8月-89','31-3月-15',1);
INSERT INTO ssh_employee values ('7', '王超 ', '156457894@qq.com', TO_DATE('1993-04-06 13:39:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2015-04-01 13:39:29', 'YYYY-MM-DD HH24:MI:SS'), '5')
INSERT INTO ssh_employee values ('8', '赵东飞', '5656456465@qq.com', TO_DATE('1989-05-10 13:39:52', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2015-04-01 13:39:48', 'YYYY-MM-DD HH24:MI:SS'), '5')
INSERT INTO ssh_employee values ('9', '姚树礼', 'ysl@163.com', TO_DATE('1992-09-22 13:40:28', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2015-04-01 13:40:50', 'YYYY-MM-DD HH24:MI:SS'), '4')
INSERT INTO ssh_employee values ('10', '牛欣', 'niuxin@163.com', TO_DATE('1990-02-13 13:40:37', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2015-04-01 13:41:05', 'YYYY-MM-DD HH24:MI:SS'), '2')
INSERT INTO ssh_employee values ('11', '谢依然', 'xieyiran@163.com', TO_DATE('1994-07-19 13:40:56', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2015-04-01 13:41:04', 'YYYY-MM-DD HH24:MI:SS'), '1')
