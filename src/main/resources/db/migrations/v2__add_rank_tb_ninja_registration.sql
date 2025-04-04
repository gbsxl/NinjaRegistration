--v2: migrations to add column rank on tb_ninjaRegistration

ALTER TABLE tb_ninja_registration
ADD COLUMN rank VARCHAR(255);