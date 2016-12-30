CREATE TABLE TCAR_USER_T (
	USER_ID INT NOT NULL AUTO_INCREMENT COMMENT '����',
	ROLE_ID INT NOT NULL COMMENT 'TCAR_ROLE_T���',
	USER_NAME VARCHAR(255) NOT NULL COMMENT '�û���',
	PASS_WORD VARCHAR(255) NOT NULL COMMENT '����',
	USER_PHONE INT NULL COMMENT '�ֻ���',
	SHOW_NAME VARCHAR(100) NULL COMMENT '��ʾ��',
	PRIMARY KEY (`USER_ID`)
)
COMMENT='�û���'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_ROLE_T(
	ROLE_ID INT PRIMARY KEY AUTO_INCREMENT comment '����',
	ROLE_TYPE CHAR(1) NOT NULL COMMENT '1:΢�ţ�2:Ա����3:����Ա',
	ROLE_NAME VARCHAR(255) NOT NULL,
	RIGHT_CODE VARCHAR(500) null 
)
COMMENT='��ɫ��'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
create table TCAR_ORDER_T(
	ORDER_ID 				INT PRIMARY KEY AUTO_INCREMENT,
	CREATE_USER_ID 			INT NOT NULL comment 'TCAR_USER_T.USER_ID', 
	CATEGORY_ID 			INT NOT NULL,			 
	GET_CAR_TYPE 			CHAR(1) NOT NULL comment '1:��ȡ��2:�ʹ�',
	ESTI_START_DATE			DATE NOT NULL comment 'Ԥ����ʼʱ��',
	ESTI_END_DATE 			DATE NOT NULL comment 'Ԥ������ʱ��',
	CT_ID					int NOT NULL comment '����',
	TOTLE_ESTI_AMT 			double(6,2) comment '��Ԥ�����',
	DEPT_ID 				int comment '���������ŵ꣬���=0�����ŵ궼�ɿ�����Ĭ��=0',
	ADDR					VARCHAR(500) comment '�ͳ���ַ',
	PROCESS_USER_ID 		INT comment '���������ˣ����ŵ�õ�Ա�����û�ID',
	ACTUAL_START_DATE 		date comment 'ʵ�ʿ�ʼʱ��',
	CAR_ID					int comment '����',
	ACTUAL_END_DATE 		date comment 'ʵ�ʽ���ʱ��',
	CREATE_TIME 			TIMESTAMP,
	UPDATE_TIME 			TIMESTAMP,
	ORDER_STATUS 			CHAR(1) comment 'A:��ȡ��;B:������;C:ȡ�� F:���;',
	ATTR1 					VARCHAR(500) comment 'ȡ��ʱ��ƬĿ¼',
	ATTR2 					VARCHAR(500) comment '����ʱ��ƬĿ¼'
)
COMMENT='������'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_CAR_T(
	CAR_ID	INT PRIMARY KEY AUTO_INCREMENT,
	CT_ID INT NOT NULL,
	PLATE_NUMBER VARCHAR(7) comment '����'
	
)
COMMENT='������'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
create table TCAR_DICTIONARY(
	DICT_ID INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(500) NOT NULL,
	DICT_TYPE CHAR(1) NOT NULL	comment 'A:����'
)
COMMENT='�ֵ��'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_CAR_MODELS_T(
	CT_ID    INT PRIMARY KEY AUTO_INCREMENT,
	CT_LEVEL_ID INT comment 'DICT_ID(DICT_TYPE=A)',
	CT_NAME VARCHAR(500),
	CT_IMG_URL VARCHAR(500) comment '��ģͼƬ·��',
	CT_DESC VARCHAR(500),
	ESTIMATE_UNIT_PRICE double(6,2)
)
COMMENT='��ģ��'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_EMPLOYEE_T(
	EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT,
	USER_ID	INT NOT NULL,
	DEPT_ID INT NOT NULL,
	ENABLE_FLAG CHAR(1) NOT NULL comment 'Y:��Ч��N:��Ч'
)
COMMENT='Ա����'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_DEPT_T(
	DEPT_ID INT PRIMARY KEY AUTO_INCREMENT,
	DEPL_PHONE INT NOT NULL,
	DEPT_NAME VARCHAR(100) NOT NULL,
	DEPT_ADDR VARCHAR(500) NOT NULL
)
COMMENT='�ŵ��'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_AUDIT_T(
	AUDIT_ID int primary key AUTO_INCREMENT,
	AUDIT_TYPE varchar(50) comment 'table Name',
	AUDIT_ACTIVE char(1)	comment '1.������2:�޸ģ�3:ɾ��'
)
COMMENT='��¼��'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
CREATE TABLE TCAR_LOG_T(
	LOG_ID int primary key AUTO_INCREMENT,
	ACTIVE_TYPE char(1) comment '1.������2.�ŵꣻ3.Ա��',
	ACTIVE_USER	int COMMENT '����Ա��',
	ACTIVE_TIME TIMESTAMP
)
COMMENT='��־��'
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('�ֶ�������','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('������','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('������','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('������','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('SUV','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('6��15������','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('���Գ�','A');
insert into TCAR_DICTIONARY(NAME,DICT_TYPE) VALUES('�綯��','A');


