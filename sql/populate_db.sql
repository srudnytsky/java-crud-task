INSERT INTO client (name)
VALUES
    ('Google'),
    ('Microsoft'),
    ('Amazon'),
    ('Tesla'),
    ('Spotify');

INSERT INTO worker (name, birthday, level, salary)
VALUES
    ('John Smith', '1990-05-10', 'Senior', 7000),
    ('Emma Johnson', '1995-03-15', 'Middle', 4500),
    ('Michael Brown', '1988-07-20', 'Senior', 8000),
    ('Sophia Davis', '2000-11-01', 'Junior', 2500),
    ('Daniel Wilson', '1998-09-12', 'Middle', 5000),
    ('Olivia Taylor', '1985-01-25', 'Senior', 9000),
    ('James Anderson', '2003-06-30', 'Trainee', 800),
    ('Isabella Thomas', '1992-04-18', 'Middle', 4800),
    ('William Jackson', '1980-12-05', 'Senior', 10000),
    ('Mia White', '1999-08-22', 'Junior', 3000);

INSERT INTO project (client_id, start_date, finish_date)
VALUES
    (1, '2023-01-01', '2023-06-01'),
    (1, '2023-02-01', '2024-02-01'),
    (2, '2022-05-10', '2023-05-10'),
    (3, '2021-03-15', '2025-03-15'),
    (4, '2023-07-01', '2023-12-01'),
    (5, '2020-01-01', '2024-01-01');

INSERT INTO project_worker (project_id, worker_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 4),

    (2, 1),
    (2, 3),
    (2, 5),

    (3, 2),
    (3, 6),

    (4, 1),
    (4, 3),
    (4, 6),
    (4, 9),

    (5, 7),
    (5, 10),

    (6, 1),
    (6, 5),
    (6, 8),
    (6, 9);