--V2: Migrations to add column DIFFICULTY on tb_ninja_registration

ALTER TABLE tb_ninja_registration
ADD COLUMN difficulty VARCHAR(255);