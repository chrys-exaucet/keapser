import React, { ChangeEvent, useState } from "react";
import "./CreateAccount.css";
import { useForm, Controller } from "react-hook-form";
import { CountryDropdown } from "react-country-region-selector";
import postman from "./axios";

interface FormData {
  email: string;
  tel: string;
  firstname: string;
  lastname: string;
  hashPass: string;
  birthday: string;
  country: string;
}

function CreateAccount() {
  const {
    register,
    handleSubmit,
    errors,
    control,
  } = useForm<FormData>({
    mode: "onSubmit",
    reValidateMode: "onChange",
    resolver: undefined,
    context: undefined,
    criteriaMode: "firstError",
    shouldFocusError: true,
    shouldUnregister: true,
    defaultValues: {
      email: "",
      tel: "",
      firstname: "",
      lastname: "",
      hashPass: "",
      birthday: "",
      country: "",
    },
  });

  const [country, setCountry] = useState<string>("");
  const [email, setEmail] = useState<string>("");
  const [tel, setTel] = useState<string>("");
  const [firstname, setFirstName] = useState<string>("");
  const [lastname, setLastName] = useState<string>("");
  const [hashPass, setHashPass] = useState<string>("");
  const [birthday, setBirthDay] = useState<string>("");

  const onSubmit = (formValues: FormData) => {
    postman
      .post("auth/add", formValues)
      .then((response) => {
        console.log(response);
        alert("Inscription complete !");
      })
      .catch((error) => {
        switch (error.request.status) {
          case 400:
            if (error.response.data.message) {
              alert(error.response.data.message);
            }
            if (error.response.data.errors !== undefined) {
              error.response.data.errors.map(
                (errorItem: string) =>
                  alert(`Error is ${errorItem}`)
              );
            }
            break;
          default:
        }
      });
  };

  return (
    <div className="createAccount">
      <div className="createAccount__info">
        <img alt="Logo KeepChat" src="/images/logo.svg" />
        <p>Connectez-vous</p>
      </div>
      <div className="createAccount__form">
        <form
          className="form"
          onSubmit={handleSubmit(onSubmit)}
        >
          <div className="form__header">
            <h1> Creez votre compte</h1>
            <h2>Vous avez deja un compte ?</h2>
            <h2>Connectez-vous</h2>
          </div>

          <div className="form__content">
            <div className="form__group">
              <label>Addresse e-mail</label>
              <input
                value={email}
                ref={register({
                  required: true,
                  maxLength: 35,
                })}
                name="email"
                type="text"
                onChange={(
                  e: ChangeEvent<HTMLInputElement>
                ) => setEmail(e.target.value)}
              />
              <div className="form__groupErrors">
                {errors.email?.type === "required" && (
                  <p>Your input is required</p>
                )}
                {errors.email?.type === "maxLength" && (
                  <p>
                    Your input max length is 35 characters
                  </p>
                )}
              </div>
            </div>

            <div className="form__group">
              <label>Numero de telephone</label>
              <input
                value={tel}
                ref={register({
                  required: true,
                  maxLength: 15,
                })}
                name="tel"
                type="text"
                onChange={(
                  e: ChangeEvent<HTMLInputElement>
                ) => setTel(e.target.value)}
              />

              <div className="form__groupErrors">
                {errors.tel?.type === "required" && (
                  <p>Your input is required</p>
                )}
                {errors.tel?.type === "maxLength" && (
                  <p>
                    Your input max length is 15 characters
                  </p>
                )}
              </div>
            </div>
            <div className="form__group">
              <label>Prenom</label>
              <input
                value={firstname}
                ref={register({
                  required: true,
                  maxLength: 40,
                })}
                name="firstname"
                type="text"
                onChange={(
                  e: ChangeEvent<HTMLInputElement>
                ) => setFirstName(e.target.value)}
              />

              <div className="form__groupErrors">
                {errors.firstname?.type === "required" && (
                  <p>Your input is required</p>
                )}
                {errors.firstname?.type === "maxLength" && (
                  <p>
                    Your input max length is 40 characters
                  </p>
                )}
              </div>
            </div>

            <div className="form__group">
              <label>Nom</label>
              <input
                value={lastname}
                ref={register({
                  required: true,
                  maxLength: 20,
                })}
                name="lastname"
                type="text"
                onChange={(
                  e: ChangeEvent<HTMLInputElement>
                ) => setLastName(e.target.value)}
              />

              <div className="form__groupErrors">
                {errors.lastname?.type === "required" && (
                  <p>Your input is required</p>
                )}
                {errors.lastname?.type === "maxLength" && (
                  <p>
                    Your input max length is 20 characters
                  </p>
                )}
              </div>
            </div>

            <div className="form__group">
              <label>Mot de passe</label>
              <input
                value={hashPass}
                ref={register({
                  required: true,
                  minLength: 8,
                })}
                name="hashPass"
                type="password"
                onChange={(
                  e: ChangeEvent<HTMLInputElement>
                ) => setHashPass(e.target.value)}
              />

              <div className="form__groupErrors">
                {errors.hashPass?.type === "required" && (
                  <p>Your input is required</p>
                )}

                {errors.hashPass?.type === "minLength" && (
                  <p>
                    Your input min length is 8 characters
                  </p>
                )}
              </div>
            </div>
            <div className="form__group">
              <label>Date de naissance</label>

              <input
                value={birthday}
                ref={register({
                  required: true,
                })}
                name="birthday"
                type="date"
                onChange={(
                  e: ChangeEvent<HTMLInputElement>
                ) => setBirthDay(e.target.value)}
              />

              <div className="form__groupErrors">
                {errors.birthday?.type === "required" && (
                  <p>Your input is required</p>
                )}
              </div>
            </div>

            <div className="form__group">
              <label>Pays</label>
              <Controller
                name="country"
                control={control}
                value={country}
                rules={{ required: true }}
                onChange={(val: string) => setCountry(val)}
                render={({ onChange, value, name }) => (
                  <CountryDropdown
                    value={value}
                    name={name}
                    valueType="full"
                    onChange={onChange}
                  />
                )}
              />
              <div className="form__groupErrors">
                {errors.country?.type === "required" && (
                  <p>Your input is required</p>
                )}
              </div>
            </div>
            <div className="form__footer">
              <button type="submit" value="Submit">
                Creer un compte
              </button>

              <p>
                Protege et soumis aux Politiques de
                confidentialite et Conditions d'utilisation
                de KeepChat
              </p>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}

export default CreateAccount;
