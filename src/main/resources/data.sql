INSERT INTO STUDENT (
    id, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, MIDDLENAME,
    SUFFIX, EMAIL_ADDRESS, CONTACT_NUMBER, YEAR, course_id
)
VALUES
    (1, 'jpcruz', '12345', 'Cruz', 'Jasper', 'Paulo', NULL,
     'jpcruz@gmail.com', '09123456789', '3rd Year', 1),

    (2, 'mgarcia', 'password', 'Garcia', 'Maria', NULL, NULL,
     'maria.garcia@gmail.com', '09876543210', '2nd Year', 2);

INSERT INTO GRADE (id, STUDENT_ID, MIDTERMS, FINALS, AVERAGE, SUBJECT_ID)
VALUES
    (1001, 1, 88.0, 92.0, 90.0, 101),
    (1002, 1, 85.0, 87.0, 86.0, 102),
    (2001, 2, 90.0, 89.0, 89.5, 201);

INSERT INTO SUBJECT (id, name, description, units, student_id)
VALUES
    (101, 'Web Development', 'Frontend and Backend Development', 3, 1),
    (102, 'Database Systems', 'Relational Databases and SQL', 3, 1),
    (201, 'Algorithms', 'Algorithm design and analysis', 3, 2);

INSERT INTO COURSE (id, course_name, description)
VALUES
    (1, 'BSIT', 'Bachelor of Science in Information Technology'),
    (2, 'BSCS', 'Bachelor of Science in Computer Science'),
    (3, 'BSBA', 'Bachelor of Science in Business Administration');

