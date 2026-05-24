DROP TABLE IF EXISTS project_worker;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS client;

CREATE TABLE client (
                        id IDENTITY PRIMARY KEY,
                        name VARCHAR(100) NOT NULL CHECK (LENGTH(name) >= 2)
);

CREATE TABLE worker (
                        id IDENTITY PRIMARY KEY,
                        name VARCHAR(100) NOT NULL CHECK (LENGTH(name) >= 2),
                        birthday DATE NOT NULL,
                        level VARCHAR(20) NOT NULL CHECK (
                            level IN ('Trainee', 'Junior', 'Middle', 'Senior')
                            ),
                        salary INT NOT NULL CHECK (salary >= 100 AND salary <= 100000)
);

CREATE TABLE project (
                         id IDENTITY PRIMARY KEY,
                         client_id BIGINT NOT NULL,
                         start_date DATE NOT NULL,
                         finish_date DATE NOT NULL,
                         CONSTRAINT fk_project_client
                             FOREIGN KEY (client_id)
                                 REFERENCES client(id)
);

CREATE TABLE project_worker (
                                project_id BIGINT NOT NULL,
                                worker_id BIGINT NOT NULL,
                                PRIMARY KEY (project_id, worker_id),

                                CONSTRAINT fk_pw_project
                                    FOREIGN KEY (project_id)
                                        REFERENCES project(id),

                                CONSTRAINT fk_pw_worker
                                    FOREIGN KEY (worker_id)
                                        REFERENCES worker(id)
);