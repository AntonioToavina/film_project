# Scénario
Il convient tout d'abord de créer une scène. Ensuite, lors de la création des actions, il apparaît que la scène nouvellement créée ne peut être sélectionnée car elle n'est pas actuellement en cours d'écriture. Par conséquent, il est nécessaire de modifier le statut de la scène et de faire usage d'Elastic Search afin de repérer la scène correspondante. Une fois cette opération achevée, la création de l'action peut se poursuivre. Lorsque celle-ci est terminée, il convient de modifier le statut de la scène, après quoi la scène ne s'affiche plus sur la page de création de l'action.

Ensuite, passer immédiatement à la suggestion de planning. Il convient ensuite d'ajouter une date d'indisponibilité pour les plateaux et les acteurs en fonction des suggestions, afin d'examiner les éventuels changements. Enfin, il est nécessaire de décocher certaines cases à cocher et de valider l'enregistrement du planning. Il est recommandé de vérifier dans la base de données si les dates d'indisponibilité des plateaux et des acteurs sont cohérentes par rapport au planning sauvegardé. Enfin, il convient de se rendre sur la page de planning, de filtrer par date et de cliquer sur "Générer PDF".