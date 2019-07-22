drop table if exists test_case;
create table test_case(
    [id]            integer PRIMARY KEY autoincrement,
    [case_name]         varchar (50),
    [case_description]      varchar (200),
    [create_time]          datetime default (datetime('now', 'localtime')),
    [update_time]          datetime default (datetime('now', 'localtime'))
);

drop table if exists test_steps;
create table test_steps(
    [id]            integer PRIMARY KEY autoincrement,
    [step_id]       int (10),
    [case_id]       integer,
    [step_description]      varchar (200),
    [object_key]            varchar (20),
    [object_value]          varchar (100),
    [action_key]            varchar (20),
    [action_value]          varchar (100),
    [verify_key]            varchar (20),
    [verify_value]          varchar (100),
    [create_time]          datetime default (datetime('now', 'localtime')),
    [update_time]          datetime default (datetime('now', 'localtime'))
);