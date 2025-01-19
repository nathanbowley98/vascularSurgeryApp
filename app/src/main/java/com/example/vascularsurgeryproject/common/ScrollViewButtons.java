package com.example.vascularsurgeryproject.common;

public class ScrollViewButtons {
    public enum MainActivityButtons {
        ROTATIONS_ESSENTIALS("Rotations Essentials"),
        ANATOMY("Anatomy"),
        PHYSIOLOGY("Physiology"),
        PATHOPHYSIOLOGY("Pathophysiology"),
        CLINICAL_REFERENCE("Clinical Reference"),
        DIAGNOSTICS_AND_IMAGING("Diagnostics and Imaging");

        private final String name;

        MainActivityButtons(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum RotationEssentialsButtons {
        ABI_SCORES("ABI Scores"),
        PERIPHERAL_EXAM_B("Peripheral Exam B"),
        COMMON_BLOOD_WORK_INFO("Common Blood Work Info");

        private final String name;

        RotationEssentialsButtons(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
