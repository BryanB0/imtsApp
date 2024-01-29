package com.example.imtsapp.models;

    public enum Priority {

        LOW(0, "faible"),
        HIGH(100, "haut");

        private final Integer level;
        private final String name;

        public Integer getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }

        Priority(int level, String name) {
            this.level = level;
            this.name = name;
        }
}
