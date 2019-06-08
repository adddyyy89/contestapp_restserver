CREATE TABLE public.admin_users
(
  adminid bigint NOT NULL,
  adminemail character varying(30)[],
  adminpwd character varying(30)[],
  isloggedin boolean,
  isdeleted boolean,
  CONSTRAINT pk_admin_users PRIMARY KEY (adminid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.admin_users
  OWNER TO postgres;

  
  -- Table: public.contest_users

-- DROP TABLE public.contest_users;

CREATE TABLE public.contest_users
(
  userid bigint NOT NULL,
  email character varying(100)[] NOT NULL,
  password character varying(50)[] NOT NULL,
  registeredon timestamp with time zone NOT NULL,
  name character varying(50)[] NOT NULL,
  gender character varying(15) NOT NULL,
  isloggedin boolean NOT NULL DEFAULT false,
  isdeleted boolean NOT NULL DEFAULT false,
  phone character varying(15) NOT NULL,
  CONSTRAINT pk_userid PRIMARY KEY (userid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contest_users
  OWNER TO postgres;

  
  -- Table: public.contestquestions

-- DROP TABLE public.contestquestions;

CREATE TABLE public.contestquestions
(
  contestid bigint NOT NULL,
  questionid bigint NOT NULL,
  addedby bigint NOT NULL,
  addedon timestamp with time zone NOT NULL,
  solvedby bigint[],
  CONSTRAINT pk_contestquestions PRIMARY KEY (contestid, questionid),
  CONSTRAINT fk_addedby FOREIGN KEY (addedby)
      REFERENCES public.admin_users (adminid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_contestquestion_contest FOREIGN KEY (contestid)
      REFERENCES public.contests (contestid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_contestquestion_question FOREIGN KEY (questionid)
      REFERENCES public.questions (questionid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contestquestions
  OWNER TO postgres;

  
  -- Table: public.contests

-- DROP TABLE public.contests;

CREATE TABLE public.contests
(
  contestid bigint NOT NULL,
  contestname character varying(100)[] NOT NULL,
  contestdate date,
  conteststarttime timestamp with time zone,
  contestendtime timestamp with time zone,
  participants jsonb,
  isactive boolean NOT NULL DEFAULT false,
  iscompleted boolean NOT NULL DEFAULT false,
  createdby bigint NOT NULL,
  createdon timestamp with time zone NOT NULL,
  CONSTRAINT pk_contest PRIMARY KEY (contestid),
  CONSTRAINT fk_createdby FOREIGN KEY (createdby)
      REFERENCES public.admin_users (adminid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contests
  OWNER TO postgres;

  
  -- Table: public.contestusers

-- DROP TABLE public.contestusers;

CREATE TABLE public.contestusers
(
  contestid bigint,
  userid bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contestusers
  OWNER TO postgres;

  
  -- Table: public.questions

-- DROP TABLE public.questions;

CREATE TABLE public.questions
(
  questionid bigint NOT NULL,
  questiontext text NOT NULL,
  questionchoices jsonb NOT NULL,
  correctchoice "char" NOT NULL,
  addedby bigint NOT NULL,
  addedon timestamp with time zone NOT NULL,
  category character varying(200)[],
  CONSTRAINT pk_question PRIMARY KEY (questionid),
  CONSTRAINT fk_questionaddedby FOREIGN KEY (addedby)
      REFERENCES public.admin_users (adminid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.questions
  OWNER TO postgres;

  
  
