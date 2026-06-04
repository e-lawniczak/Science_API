import {
    FormProvider,
    useForm
} from "react-hook-form";

import DisorderNode from "./DisorderNode";
import { APIClient } from "../../helpers/APIClient";
import { API_ROUTES } from "../../components/common/API_ROUTES";

export default function CreateDisorderPage() {

    const methods = useForm({
        defaultValues: {
            root: {
                code: "",
                name: "",
                description: "",
                symptoms: [],
                keywords: [],
                children: []
            }
        }
    });

    const submit = async (data: any) => {

        console.log(data.root);

        var api = new APIClient()
        var res = await api.post(API_ROUTES.postDisorder, data.root)
        console.log(res)
    };

    return (
        <FormProvider {...methods}>

            <form
                onSubmit={methods.handleSubmit(
                    submit
                )}
            >

                <DisorderNode path="root" />

                <button type="submit">
                    Save
                </button>

            </form>

        </FormProvider>
    );
}