export interface DisorderForm {
    code: string;
    name: string;
    description: string;

    symptoms: {
        name: string;
    }[];

    keywords: {
        value: string;
    }[];

    children: DisorderForm[];
}