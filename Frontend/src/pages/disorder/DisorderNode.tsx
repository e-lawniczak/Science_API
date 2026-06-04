import {
    useFieldArray,
    useFormContext
} from "react-hook-form";

type Props = {
    path: string;
};

export default function DisorderNode({
    path,
}: Props) {

    const { register, control } = useFormContext();

    const {
        fields: children,
        append: addChild,
        remove: removeChild
    } = useFieldArray({
        control,
        name: `${path}.children`
    });

    const {
        fields: symptoms,
        append: addSymptom,
        remove: removeSymptom
    } = useFieldArray({
        control,
        name: `${path}.symptoms`
    });

    const {
        fields: keywords,
        append: addKeyword,
        remove: removeKeyword
    } = useFieldArray({
        control,
        name: `${path}.keywords`
    });

    return (
        <div
            style={{
                border: "1px solid #ccc",
                padding: "1rem",
                marginLeft: "1rem",
                marginTop: "1rem"
            }}
        >
            <input
                placeholder="Code"
                {...register(`${path}.code`)}
            />

            <input
                placeholder="Name"
                {...register(`${path}.name`)}
            />

            <textarea
                placeholder="Description"
                {...register(`${path}.description`)}
            />

            <h4>Symptoms</h4>

            {symptoms.map((symptom, index) => (
                <div key={symptom.id}>
                    <input
                        placeholder="Symptom"
                        {...register(
                            `${path}.symptoms.${index}.name`
                        )}
                    />

                    <button
                        type="button"
                        onClick={() =>
                            removeSymptom(index)
                        }
                    >
                        Remove
                    </button>
                </div>
            ))}

            <button
                type="button"
                onClick={() =>
                    addSymptom({ name: "" })
                }
            >
                Add symptom
            </button>

            <h4>Keywords</h4>

            {keywords.map((keyword, index) => (
                <div key={keyword.id}>
                    <input
                        placeholder="Keyword"
                        {...register(
                            `${path}.keywords.${index}.value`
                        )}
                    />

                    <button
                        type="button"
                        onClick={() =>
                            removeKeyword(index)
                        }
                    >
                        Remove
                    </button>
                </div>
            ))}

            <button
                type="button"
                onClick={() =>
                    addKeyword({ value: "" })
                }
            >
                Add keyword
            </button>

            <h4>Subtypes</h4>

            {children.map((child, index) => (
                <div key={child.id}>
                    <DisorderNode
                        path={`${path}.children.${index}`}
                    />

                    <button
                        type="button"
                        onClick={() =>
                            removeChild(index)
                        }
                    >
                        Remove subtype
                    </button>
                </div>
            ))}

            <button
                type="button"
                onClick={() =>
                    addChild({
                        code: "",
                        name: "",
                        description: "",
                        symptoms: [],
                        keywords: [],
                        children: []
                    })
                }
            >
                Add subtype
            </button>
        </div>
    );
}