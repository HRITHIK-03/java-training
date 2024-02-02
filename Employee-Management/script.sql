-- public.mt_employee definition

-- Drop table

-- DROP TABLE public.mt_employee;

CREATE TABLE public.mt_employee (
	emp_id bigserial NOT NULL,
	dob timestamp(6) NULL,
	"name" varchar(255) NULL,
	salary varchar(255) NULL,
	CONSTRAINT mt_employee_pkey PRIMARY KEY (emp_id)
);