export interface ProjectPage {
    name: string,
    path: string,
    className?: string,
    label?: string,
    element: any,
}

export interface IChronologyEntry {
    dateStart?: Date | null,
    dateEnd?: Date | null,
    title: string
}
export interface TechStack {
    techName: string,
    techIcon?: string
}
export interface EducationInfo extends IChronologyEntry {
    degree: string,
    institution: string,
    major?: string
}
export interface WorkInfo extends IChronologyEntry {
    company: string,
    description: any,
    techStack: TechStack[],
    workplaceLogo: string,
}
export type ProjectType = "JAVA" | "C#" | "OTHER" | "all"

export interface ProjectInfo extends IChronologyEntry {
    githubUrl: string,
    description: any,
    techStack: TechStack[],
    type: ProjectType
}
export type SkillExperience = "Using at work" | "Used at uni" | "Using personally" | "Using personally & at work" | "Used at uni & personally"
export type SectionType = "scripting" | "engine" | "web" | "langs" | "other"
export interface SkillEntry {
    skill: string,
    exp: SkillExperience,
    section: SectionType
} 