
INSERT INTO roles (name, description) VALUES
                                          ('ADMIN', 'Administrator'),
                                          ('STUDENT', 'Student'),
                                          ('TEACHER', 'Teacher'),
                                          ('PROMOTER', 'Promoter')
    ON CONFLICT (name) DO NOTHING;